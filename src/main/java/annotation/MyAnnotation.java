package annotation;

import java.lang.annotation.*;

// target用来表明自定义的注解适用于什么地方
@Target(ElementType.METHOD)
// 在什么级别保存该注解信息
@Retention(RetentionPolicy.RUNTIME)
// 是否在javadoc中
@Documented
// 是否能够被继承
@Inherited
public @interface MyAnnotation {
    String name() default "zhangsan";
    int age() default 12;
}
