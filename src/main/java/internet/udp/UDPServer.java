package internet.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(10001);
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
        // 用创建好的数据包接收数据
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        datagramSocket.close();
    }
}
