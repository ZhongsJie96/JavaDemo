package internet.socket.recordInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;
    BufferedReader br = null;
    PrintStream ps = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(Protocol.USER_ROUND) && line.endsWith(Protocol.USER_ROUND)) {
                    String userName = getRealMsg(line);
                    if (Server.clients.map.containsKey(userName)) {
                        System.out.println("重复");
                        ps.println(Protocol.NAME_REP);
                    } else {
                        System.out.println("成功");
                        ps.println(Protocol.LOGIN_SUCCESS);
                        Server.clients.put(userName, ps);
                    }
                } else if (line.startsWith(Protocol.PRIVATE_ROUND) && line.endsWith(Protocol.PRIVATE_ROUND)) {
                    String userAndMsg = getRealMsg(line);
                    String user = userAndMsg.split(Protocol.SPLIT_SIGN)[0];
                    String msg = userAndMsg.split(Protocol.SPLIT_SIGN)[1];
                    Server.clients.map.get(user).println(Server.clients.getKeyByValue(ps) + "悄悄对你说" + msg);
                } else {
                    String msg = getRealMsg(line);
                    for (PrintStream clients : Server.clients.valueSet()) {
                        clients.println(Server.clients.getKeyByValue(ps) + "说" + msg);
                    }
                }
            }

        } catch (IOException e) {
            Server.clients.removeByValue(ps);
            System.out.println(Server.clients.map.size());
            try {
                if (br != null) {
                    br.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private String getRealMsg(String line) {
        return line.substring(Protocol.PROTOCOL_LEN, line.length() - Protocol.PROTOCOL_LEN);
    }
}
