package TCPTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class TestURL {
    public static void main(String[] args) {
        try{
            String s_url = "https://www.baidu.com/";
            URL url = new URL(s_url);
            System.out.println(url.getAuthority());
            System.out.println(url.getContent());
            System.out.println(url.getDefaultPort());
            System.out.println(url.getFile());
            System.out.println(url.getHost());
            System.out.println(url.getPath());
            System.out.println(url.getPort());
            System.out.println(url.getProtocol());
            InputStream in = url.openStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in));
            String msg = null;
            while((msg = reader.readLine()) !=null){
                System.out.println(msg);
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
}
