package designPatterns.factoryMethod;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {
    /**
     * 返回接口的所有实现类
     * @param c
     * @return
     */
    public static List<Class> getAllClassByInterface(Class c) {
        List<Class> returnClassList = new ArrayList<>();

        if (c.isInterface()) {
            String packageName = c.getPackage().getName();

            try {
                // 获取当前包下以及子包下的所有类
                List<Class> allClass = getClasses(packageName);

                for (int i = 0; i < allClass.size(); i++) {
                    // 判断此Class对象所表示的类或接口与指定的Class参数所表示的类或接口是否相同，或是否是其超类或超接口
                    if (c.isAssignableFrom(allClass.get(i))) {
                        if (!c.equals(allClass.get(i))) {
                            returnClassList.add(allClass.get(i));
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnClassList;
    }

    /**
     * 获取包的所有类,在jar包中不能查找
     * @param packageName
     * @return
     */
    private static List<Class> getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".","/");
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClassed(directory, packageName));
        }
        return classes;
    }

    /**
     * 在目录中寻找Class文件
     * @param directory
     * @param packageName
     * @return
     * @throws ClassNotFoundException
     */
    private static List<Class> findClassed(File directory, String packageName) throws  ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            // 查找子目录
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClassed(file, packageName + "." + file.getName()));
            // class文件
            } else if (file.getName().endsWith(".class")){
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length()-6)));
            }
        }
        return classes;
    }
}
