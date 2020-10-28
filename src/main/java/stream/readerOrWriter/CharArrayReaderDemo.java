package stream.readerOrWriter;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        char[] chars = "搞事情".toCharArray();
        CharArrayReader charArrayReader = null;
        charArrayReader = new CharArrayReader(chars);

        try {
            int read = 0;
            while ((read = charArrayReader.read()) != -1) {
                System.out.println((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            charArrayReader.close();
        }

    }

}
