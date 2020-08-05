package day23;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
* 客户端:
* 1， 建立socket服务，指定要连接的主机和接口
* 2， 获取socket流中的输出流，将要发送数据写入流中，通过网络发送给服务端
* 3， 获取socket流中的输入流，将服务端反馈的数据获取并输出到控制台
* 4， 关闭客户端资源
* */
public class TCPDemo2 {
}
class TcpClient2{
    public static void main(String[] args) throws Exception{
        Socket clientSocket = new Socket("169.254.160.34",8888);

        OutputStream out = clientSocket.getOutputStream();
        out.write("你好，服务端".getBytes());

        InputStream in = clientSocket.getInputStream();
        byte[] serverData = new byte[1024];
        int len = in.read(serverData);//read阻塞

       System.out.println("服务端:"+new String(serverData,0,len));

       clientSocket.close();
    }
}

class TcpServer2{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket clientSocket = serverSocket.accept();//accept阻塞
        String ip = clientSocket.getInetAddress().getHostAddress();

        InputStream inputStream = clientSocket.getInputStream();

        byte[] clientData = new byte[1024];

        int len = inputStream.read(clientData);//read阻塞

        System.out.println("客户端:"+new String(clientData,0,len)+"来自ip:"+ip);

        OutputStream outputStream = clientSocket.getOutputStream();

        outputStream.write("服务端收到！".getBytes());

        clientSocket.close();
        serverSocket.close();
    }
}
