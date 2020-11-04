package java8.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        Supplier<String> s1 = ()->"1";
        Consumer<Integer> c1 = Fun::test;

    }
}

class Fun{
    public static void test(int i) {
        System.out.println("fun");
    }
}
