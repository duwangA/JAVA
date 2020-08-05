package day23;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadTestDemo {
}
class TextClient{
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("169.254.160.34",8888);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("IPDemo.java"));

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

//        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//        long time = System.currentTimeMillis();
//        dos.writeLong(time);
//        System.out.println(time);
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            out.println(line);
        }
        socket.shutdownOutput();//关闭客户端输出流，相当于给流加一个结束标记-1
//        out.println("over");
//        dos.writeLong(time);//时间戳

        BufferedReader ServerReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String serverdata = ServerReader.readLine();
        System.out.println("Sever:"+serverdata);

        bufferedReader.close();
        socket.close();
    }

}

class TextServer{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket client  = serverSocket.accept();
        String ip = client.getInetAddress().getHostAddress();
        System.out.println("ip:"+client+"has connected...");

//        DataInputStream dis = new DataInputStream(client.getInputStream());
//        Long t = dis.readLong();
//        System.out.println(t);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        /*正常最好先让客户端发名字，然后做处理*/
        PrintWriter out = new PrintWriter(new FileWriter("client.txt"),true);
//        Long t2 = null;
        String line = null;
        //readline()正常情况一定不会返回null，而是阻塞，得设定判定条件让他退出
        while ((line = bufferedReader.readLine()) != null) {
            out.println(line);
//            t2 = dis.readLong();
//            if(t2.equals(t)){
//                System.out.println(t2);
//                break;
//            }

        }
        PrintWriter back = new PrintWriter(client.getOutputStream(),true);
        back.println("上传成功");

        out.close();
        client.close();
        serverSocket.close();
    }

}
