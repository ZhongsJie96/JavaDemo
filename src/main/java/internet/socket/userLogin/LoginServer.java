package internet.socket.userLogin;

import internet.socket.recordInfo.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(20000);

        for (;;) {
            // 接收Socket
            Socket server = serverSocket.accept();

            // 接受客户端数据
            InputStream inputStream = server.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            User user = (User) objectInputStream.readObject();
            String str = "";

            if ("123".equals(user.getUsername()) && "123".equals(user.getPassword())) {
                str = "登录成功";
            } else {
                str = "登录失败";
            }
            server.shutdownInput();

            // 给客户端响应
            OutputStream outputStream = server.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(str);
            server.shutdownOutput();

            dataOutputStream.close();
            outputStream.close();
            objectInputStream.close();
            inputStream.close();
            server.close();
        }
//        serverSocket.close();
    }
}
