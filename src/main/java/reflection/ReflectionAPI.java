package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionAPI {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("reflection.Student");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
//            System.out.println(field.getModifiers());
        }

        System.out.println("-------");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
//            System.out.println(declaredField.getModifiers());
        }

        System.out.println("----------");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
//            System.out.println(method.getModifiers());
        }

        System.out.println("--------------");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        System.out.println("--------------");
        Method add = clazz.getDeclaredMethod("add", int.class, int.class);
        add.setAccessible(true);
        Object o = clazz.newInstance();
        add.invoke(o, 123, 123);

        System.out.println("--------------");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("--------------");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
        System.out.println("--------------");
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Student test = (Student)constructor.newInstance("test");
        System.out.println(test);


    }
}
