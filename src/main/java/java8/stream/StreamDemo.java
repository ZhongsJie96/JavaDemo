package java8.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void generateByArray() {
        String[] strs = {"a","b", "c"};
        Stream<String> strs1 = Stream.of(strs);
        strs1.forEach(System.out::println);
    }

    public static void generateByList() {
        List<String> list = Arrays.asList("a","b", "c");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    public static void generate3() {
        Stream<Integer> stream = Stream.generate(()->1);
        stream.limit(10).forEach(System.out::println);
    }

    public static void generate4() {
        Stream<Integer> stream = Stream.iterate(1, x->x+1);
        stream.limit(10).forEach(System.out::println);
    }
    public static void main(String[] args) {
        // Stream生成操作
//        generateByArray();
//        generateByList();
//        generate4();

        // Stream中间操作

        System.out.println(Arrays.asList(1, 2, 3, 4).stream().filter((x) -> x % 2 == 0).mapToInt(x->x).sum());


        List<Integer> list = Arrays.asList(1,3,5,4,6,2);

        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println(max.get());

        System.out.println("sort");
        list.stream().sorted((a, b) -> a - b).forEach(System.out::println);

        List<Integer> list1 = Arrays.asList(1,3,5,4,6,2);
        Integer integer = list1.stream().sorted().findFirst().get();
        System.out.println(integer);

        Integer integer1 = list1.stream().sorted((a, b) -> b - a).findFirst().get();
        System.out.println(integer1);


        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        // 去重
        Arrays.asList(1,2,3,3,3,3,3,5,4).stream().distinct().forEach(System.out::println);
        // 打印
        Stream.iterate(1, x->x+1).limit(50).skip(20).limit(10).forEach(System.out::println);

        String str = "11,22,33,44";
        System.out.println(Arrays.stream(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());

        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

    }
}
