package stream.readerOrWriter;

import java.io.*;

public class BufferedReaderDemo {
    public static void main(String[] args) {


        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("aaa.txt"));
            String read = null;
            while ((read = bufferedReader.readLine()) != null) {
                System.out.println(read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
