package internet.socket.recordInfo;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread {
    BufferedReader br = null;
    public ClientThread(BufferedReader br) {
        this.br = br;
    }
    @Override
    public void run() {
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
