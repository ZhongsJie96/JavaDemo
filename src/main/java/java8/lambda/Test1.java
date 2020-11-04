package java8.lambda;

import java.util.function.Supplier;

public class Test1 {
    public String put() {
        return "putting...";
    }

    public static void main(String[] args) {
        System.out.println(new Test1().put());

        Supplier<String> s1 = ()->new Test1().put();
        Supplier<String> s2 = new Test1()::put;

        System.out.println(s1.get());
        System.out.println(s2.get());

    }

}
