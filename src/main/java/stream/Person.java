package stream;

import java.io.Serializable;

/**
 * 需要使用object流的时候需要实现序列化，并且加上序列化的值
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 15L;

    private int id;
    private String name;
    private transient String psw;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }

    public Person(int id, String name, String psw) {
        this.id = id;
        this.name = name;
        this.psw = psw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }


}
