package day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/*
* 需求：通过UDP方式，将一段文字发送出去
*
* 1， 建立UDP SOCKET服务
* 2， 提供数据，并将数据封装到数据报包中
* 3， 通过socket服务的发送功能将数据报发送出去
* 4， 关闭资源
* */
public class UdpDemo {
    public static void main(String[] args) throws IOException {
        //创建UDP服务
        DatagramSocket datagramSocket = new DatagramSocket();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = null;

        /*readline阻塞*/
        while ((line = bufferedReader.readLine())!= null) {
            if ("886".equals(line))
                break;
            byte[] data = line.getBytes();

            DatagramPacket datagramPacket = new DatagramPacket(data,data.length, InetAddress.getByName("169.254.160.34"),8888);
            datagramSocket.send(datagramPacket);
        }

        datagramSocket.close();
    }
}
