package stream;

import java.io.*;

public class DataInputStreamDemo {
    public static void main(String[] args) {
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            outputStream = new FileOutputStream("abc.txt");
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeUTF("搞事情");

            inputStream = new FileInputStream("abc.txt");
            dataInputStream = new DataInputStream(inputStream);
            boolean b = dataInputStream.readBoolean();
            System.out.println(dataInputStream.readUTF());
            System.out.println(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
