package exercise;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 分块读取数据
 * @author zhong
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        File file = new File("doc.txt");
        long length = file.length();
        int blockSize = 1024;
        int blockCnt = (int) Math.ceil(length * 1.0 / blockSize);
        int beginPos = 0;
        int actualSize = (int) (length > blockSize ? length : blockSize);

        for (int i = 0; i < blockCnt; i++) {
            beginPos = i * blockSize;
            if (i == blockCnt - 1) {
                actualSize = (int) length - (blockCnt - 1) * actualSize;
            } else {
                actualSize = blockSize;
            }
            System.out.println();
            System.out.println(i + "---" + "--beginPos--" + beginPos + "--actualSize--" + actualSize);
            blockRead(i, beginPos, actualSize);
        }
    }


    public static void blockRead(int i, int beginPos, int actualSize) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("doc.txt"), "r");
            // 设置偏移量
            randomAccessFile.seek(beginPos);
            // 设置缓冲区
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = randomAccessFile.read(buffer)) != -1) {
                if (actualSize > length) {
                    System.out.println(new String(buffer, 0, length));
                    actualSize -= length;
                } else {
                    System.out.println(new String(buffer, 0, actualSize));
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert randomAccessFile != null;
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
