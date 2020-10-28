package stream;

import java.io.*;

public class ObjectOutputStreamDemo {

    public static void main(String[] args) {
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            outputStream = new FileOutputStream("abc.txt");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeUTF("搞事情");
            objectOutputStream.writeObject(new Person(1, "zhangsan", "123456"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
