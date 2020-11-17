package jdbc.entity;

import java.util.HashMap;

/**
 * 枚举类
 */
public enum Gender {
    // 男性，女性
    MALE("M", 1), FAMALE("F", 2);
    private String key;
    private Integer value;
    private static HashMap<Integer, Gender> valueMap = new HashMap<>();

    static {
        for (Gender item : Gender.values()) {
            valueMap.put(item.getValue(), item);
        }
    }
    Gender(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static Gender getByValue(int value) {
        Gender result = valueMap.get(value);
        if (result == null) {
            throw new IllegalArgumentException("No element matches");
        }
        return result;
    }
}
