package java8.lambda;


import java.util.function.Consumer;
import java.util.function.Supplier;

public class Test2 {
    public static void main(String[] args) {
        Consumer<Foo> c1 = (Foo foo)->new Foo().fun();
        c1.accept(new Foo());

        Consumer<Foo> c2 = (Foo foo)->new Foo2().show();
        c2.accept(new Foo());

        Consumer<Foo> c3 = Foo::fun;
        c3.accept(new Foo());

        Supplier<Foo> s1 = ()-> new Foo();
        Supplier<Foo> s2= Foo::new;

        Foo foo = s1.get();
        Foo foo1 = s2.get();
    }
}

class Foo {
    public Foo() {
        System.out.println("无参");
    }
    public Integer fun(String s) {
        return s.length();
    }

    public void fun() {
        System.out.println("foo");
    }
}

class Foo2 {
    public Integer fun(String s) {
        return s.length();
    }

    public void fun() {
        System.out.println("foo2---");
    }

    public void show() {
        System.out.println("foo2");
    }
}
