package stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        String str = "southwest";

        byte[] buffer = str.getBytes();

        ByteArrayInputStream byteArrayInputStream = null;

        byteArrayInputStream = new ByteArrayInputStream(buffer);

        int read = 0;

        while ((read = byteArrayInputStream.read()) != -1) {
            // 跳几个字符
            byteArrayInputStream.skip(3);
            System.out.println((char)read);
        }

        try {
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
