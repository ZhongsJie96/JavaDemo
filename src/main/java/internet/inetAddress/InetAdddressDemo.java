package internet.inetAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.baidu.com");
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostName());
            InetAddress inetAdd = InetAddress.getByName("DESKTOP-3Q941FL");
            System.out.println(inetAdd);
            System.out.println(ip.isReachable(2000));
            System.out.println(ip.getHostAddress());
            System.out.println(ip.getHostName());
            System.out.println(ip.getCanonicalHostName());
            InetAddress localHost1 = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
            System.out.println("localhost:" + localHost1.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
