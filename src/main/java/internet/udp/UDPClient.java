package internet.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(10000);

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),
                str.length(), InetAddress.getByName("localhost"), 10001);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
