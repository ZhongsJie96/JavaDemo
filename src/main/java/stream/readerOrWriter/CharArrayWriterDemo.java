package stream.readerOrWriter;

import java.io.CharArrayWriter;

public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter charArrayWriter = null;
        charArrayWriter = new CharArrayWriter();
        charArrayWriter.write(99);
        System.out.println(charArrayWriter.toString());
        charArrayWriter.close();
    }
}
