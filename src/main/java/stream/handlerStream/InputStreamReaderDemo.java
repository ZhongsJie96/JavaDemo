package stream.handlerStream;


import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 使用处理流是由于网路编程中提高效率
 * socket只能getInputStream
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        File file = new File("abc.txt");
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;

        try {
            inputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            int length = 0;
            char[] buffer = new char[1024];
            while ((length = inputStreamReader.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, length));
            }

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();
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
