package day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//编写一个聊天程序(多线程)
//发送类的ip改成对方即可聊天
public class ChatDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket sendSocket = new DatagramSocket();
        DatagramSocket receiveSocket = new DatagramSocket(8888);

        new Thread(new Send(sendSocket)).start();
        new Thread(new Receive(receiveSocket)).start();
    }
}
class Send implements Runnable{
    private DatagramSocket datagramSocket;

    public Send(DatagramSocket datagramSocket){
        this.datagramSocket = datagramSocket;
    }
    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String line = null;


            while ((line = bufferedReader.readLine())!= null){
                if ("886".equals(line))
                    break;
                byte[] data = line.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(data,data.length, InetAddress.getByName("169.254.160.34"),8888);
                datagramSocket.send(datagramPacket);
            }
        }catch (Exception e){
            throw new RuntimeException("处理不了");
        }
    }
}
class Receive implements Runnable{
    private DatagramSocket datagramSocket;
    public Receive(DatagramSocket datagramSocket){
        this.datagramSocket = datagramSocket;
    }
    @Override
    public void run() {
        try {

            while (true){
                byte[] data = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(data,data.length);

                datagramSocket.receive(datagramPacket);

                String ip = datagramPacket.getAddress().getHostAddress();
                String s = new String(datagramPacket.getData(),0,datagramPacket.getLength());

                System.out.println(ip+":"+s+"!");
            }
        }catch (Exception e){
            throw new RuntimeException("不行");
        }

    }
}