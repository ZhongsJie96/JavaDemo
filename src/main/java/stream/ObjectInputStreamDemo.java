package stream;

import java.io.*;

/**
 * 对象进行io流传输，必须实现序列化接口
 * 需要一个serialVersionUID
 * transient关键字修饰的变量，不会被序列化
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            inputStream = new FileInputStream("abc.txt");
            objectInputStream = new ObjectInputStream(inputStream);

            System.out.println(objectInputStream.readUTF());
            Object obj = objectInputStream.readObject();
            if (obj instanceof Person) {
                Person p = (Person) obj;
                System.out.println(p.toString());
            }

        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert objectInputStream != null;
                // 关闭之前进行断言的判断
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
