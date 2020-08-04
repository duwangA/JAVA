package day23;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
* 1， 定义udpSocket服务
* 2， 定义一个数据包，因为要存储接收到的字节数据，数据包对象有更多功能可以提取字节数据中的不同数据信息
* 3， 通过socket服务的receive方法将接收到的数据存入已经定义好的数据报中
* 4，通过数据包的特有功能，将这些不同的数据取出，打印在控制台上
* */
public class UDPRevDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocketReciever = new DatagramSocket(8888);
        try {

            while (true) {
                byte[] recv = new byte[1024];
                DatagramPacket datagramPacketReciever = new DatagramPacket(recv, recv.length);

                //receive阻塞
                datagramSocketReciever.receive(datagramPacketReciever);

                java.lang.String ip = datagramPacketReciever.getAddress().getHostAddress();
                String data = new String(datagramPacketReciever.getData(), 0, datagramPacketReciever.getLength());
                int port = datagramPacketReciever.getPort();
                System.out.println("ip=" + ip  + "port=" + port+ "::::::: 发来消息=" + data);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            datagramSocketReciever.close();
        }

    }


}
