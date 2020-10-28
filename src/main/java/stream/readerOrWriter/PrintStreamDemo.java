package stream.readerOrWriter;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(System.out);
            printStream.write("southwest".getBytes());
            printStream.printf("%s", "String");
        } catch (IOException e) {
            e.printStackTrace();
        }
        printStream.close();
    }
}
