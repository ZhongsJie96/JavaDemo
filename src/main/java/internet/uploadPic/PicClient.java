package internet.uploadPic;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PicClient {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("1.jpg");

        Socket client = new Socket("localHost", 20000);

        OutputStream outputStream = client.getOutputStream();
        int read = 0;

        while ((read = fileInputStream.read()) != -1) {
            outputStream.write(read);
        }

        client.shutdownOutput();
        // 接收响应
        InputStream inputStream = client.getInputStream();
        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);

        System.out.println(new String(buf, 0, length));

        client.shutdownInput();

        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        client.close();
    }

}
