package map.hashmap;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);

        map.forEach((k,v) -> {
            System.out.println("key:" + k + " value:" + v);
        });
    }
}
