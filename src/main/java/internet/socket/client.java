package internet.socket;

import java.io.*;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws IOException {
        // 创建Socket
        Socket socket = new Socket("localHost", 20000);
        // 设置超时时长
        socket.setSoTimeout(10000);

        OutputStream outputStream = socket.getOutputStream();
        // 将输出流对象进行包装
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        // 传输数据
        dataOutputStream.writeUTF("server hello");
        // 读取服务端消息
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String s = dataInputStream.readUTF();
        System.out.println(s);
        // 关闭流
        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }
}
