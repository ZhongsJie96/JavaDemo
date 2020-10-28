package internet.socket.multiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(20000);
        for (; ; ) {
            Socket s = serverSocket.accept();
            socketList.add(s);
            new Thread(new ServerThread(s)).start();
        }
    }
}


