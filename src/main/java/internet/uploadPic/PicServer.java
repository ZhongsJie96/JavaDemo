package internet.uploadPic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PicServer {

    public static void main(String[] args) throws IOException {
        // 开放端口
        ServerSocket serverSocket = new ServerSocket(20000);
        // 接收客户端socket
        Socket server = serverSocket.accept();
        InputStream inputStream = server.getInputStream();
        // 文件输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("123.jpg");
        int read = 0;
        while ((read = inputStream.read()) != -1) {
            fileOutputStream.write(read);
        }
        // 手动关闭流
        server.shutdownInput();
        // 添加流输出完成的标志

        // 给客户端相应
        OutputStream outputStream = server.getOutputStream();
        outputStream.write("上传成功".getBytes());

        server.shutdownOutput();
        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();
    }
}
