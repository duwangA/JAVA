package day23;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;

//public class TCPDemo {
//
//}
class TcpClient{
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("169.254.160.34"/*InetAddress.getByName("169.254.160.34")*/,8888);

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("tcp connected 1".getBytes());

        socket.close();
    }
}

class TcpServer{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket clientsocket = serverSocket.accept();//监听

        InputStream inputStream = clientsocket.getInputStream();//通过客户端socket对象获取对应读取流读取数据

        byte[] buf = new byte[1024];
        int len = inputStream.read(buf);//往buf里面读

        System.out.println(new String(buf,0,len));

        System.out.println("ip="+clientsocket.getInetAddress().getHostAddress());

        clientsocket.close();
        serverSocket.close();
    }
}