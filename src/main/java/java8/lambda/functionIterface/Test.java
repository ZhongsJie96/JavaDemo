package java8.lambda.functionIterface;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 13, 78));
        list.add(new Student("lisi", 11, 98));
        list.add(new Student("wangwu", 14, 58));
        list.add(new Student("zhaoliu", 17, 62));

        List<Student> ans = getByFilter(list, (stu) -> stu.getAge() > 12);
        printStu(ans);
    }

    public static List<Student> getByFilter(List<Student> list, StudentFilter filter) {
        List<Student> ans = new ArrayList<>();
        for (Student stu : list) {
            if (filter.compare(stu)) {
                ans.add(stu);
            }
        }
        return ans;
    }

    public static void printStu(List<Student> list) {
        list.forEach(System.out::println);
    }
}
