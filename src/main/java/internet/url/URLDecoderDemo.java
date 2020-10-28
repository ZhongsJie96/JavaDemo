package internet.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String kw = URLDecoder.decode("%B8%E3%CA%C2%C7%E9", "GBK");

        System.out.println(kw);

        String urlStr = URLEncoder.encode("搞事情", "GBK");

        System.out.println(urlStr);
    }
}
