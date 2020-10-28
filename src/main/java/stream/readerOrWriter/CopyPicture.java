package stream.readerOrWriter;

import java.io.*;

/**
 * 图片视频需要用字节流来处理，字符流处理将会出现错误
 */
public class CopyPicture {
    public static void main(String[] args) {
//        FileReader reader = null;
//        FileWriter writer = null;
//
//        try {
//            reader = new FileReader("1.jpg");
//            writer = new FileWriter("2.jpg");
//            int length = 0;
//            char[] buffer = new char[1024];
//            while ((length = reader.read(buffer)) != -1) {
//                writer.write(buffer);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("1.jpg");
            outputStream = new FileOutputStream("2.jpg");

            int length = 0;
            byte[] buffer = new byte[1024];

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
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
