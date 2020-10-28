package internet.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws IOException {
        // 服务端开放端口
        ServerSocket server = new ServerSocket(20000);

        // 获取socket对象
        Socket socket = server.accept();
        // 将输入流包装
        // 接收客户端消息
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String s = dataInputStream.readUTF();
        System.out.println(s);
        // 传输消息到服务端
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("client hello");
        // 关闭流
        dataInputStream.close();
        inputStream.close();
        socket.close();
        server.close();
    }
}
