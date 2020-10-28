package internet.socket.recordInfo;


import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int SERVER_PORT = 20000;
    public static SocketMap<String, PrintStream> clients = new SocketMap<>();
    public void init() {
        try(
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT); ) {
            while (true) {
                Socket s = serverSocket.accept();
                new ServerThread(s).start();
            }
        } catch (IOException e) {
            System.out.println("服务器启动失败，是否端口" + SERVER_PORT + "已被占用");
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
    }

}
