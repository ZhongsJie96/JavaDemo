package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("java8/lambda")).start();

        List<String> list = Arrays.asList("java", "javaScript", "python");

        Collections.sort(list, (o1, o2)->o1.length()-o2.length());
        list.forEach(System.out::println);
    }
}
