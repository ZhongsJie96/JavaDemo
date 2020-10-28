package stream.handlerStream;

import java.io.*;

/**
 * 使用处理流保证了灵活性，可以定义字符集。同时节省处理时间
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {

        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            long start = System.currentTimeMillis();
            outputStream = new FileOutputStream("abc.txt");
            outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
            outputStreamWriter.write(99);
            outputStreamWriter.write("southwest");
            outputStreamWriter.write("abcdef", 0, 4);
            long end = System.currentTimeMillis();
            System.out.println(end-start);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
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
