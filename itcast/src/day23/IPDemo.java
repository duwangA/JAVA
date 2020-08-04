package day23;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] inetAddress = InetAddress.getAllByName("www.baidu.com");
        System.out.println(InetAddress.getLocalHost());

       for(int x = 0;x<inetAddress.length;x++){
            System.out.println(inetAddress[x].getHostName()+"::"+inetAddress[x].getHostAddress());
        }
    }
}
