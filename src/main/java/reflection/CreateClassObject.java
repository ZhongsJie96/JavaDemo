package reflection;

import jdbc.entity.Employees;

public class CreateClassObject {
    public static void main(String[] args) throws Exception {
        // 1. 通过Class.forname()
        Class<?> clazz = Class.forName("jdbc.entity.Employees");
        System.out.println(clazz.getPackage());
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName());

        // 2.通过类名.class来获取
        Class<?> employeesClass = Employees.class;

        // 3. 通过对象的getClass()来获取
        Class<?> aClass = new Employees().getClass();

        // 基本数据类型，可以通过type的方式来获取Class对象
        Class<Integer> type = Integer.TYPE;

    }
}
