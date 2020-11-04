package nio;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelDemo {
    public static void main(String[] args) {
        File f = new File("D:/IDEA-Repository/JavaDemo/src/main/java/nio/FileChannelDemo.java");
        try (
            FileChannel inChannel = new FileInputStream(f).getChannel();
            FileChannel outChannel = new FileOutputStream("a.txt").getChannel();
        ) {
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            Charset charset = Charset.forName("GBK");
            outChannel.write(buffer);
            // 创建解码器
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);

            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
