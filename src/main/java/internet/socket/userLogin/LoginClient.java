package internet.socket.userLogin;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {

    public static void main(String[] args) throws Exception{
        Socket client = new Socket("localHost", 20000);

        // 向服务端发送对象
        OutputStream outputStream = client.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(getUser());
        client.shutdownOutput();
        // 接收服务端响应
        InputStream inputStream = client.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String str = dataInputStream.readUTF();
        System.out.println(str);
        // 半关闭状态
        client.shutdownInput();
        // 关闭流
        inputStream.close();
        outputStream.close();
        dataInputStream.close();
        objectOutputStream.close();
        client.close();
    }

    public static User getUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        return new User(username, password);
    }
}
