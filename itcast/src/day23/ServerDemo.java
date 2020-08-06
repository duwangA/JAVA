package day23;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);



            Socket client = serverSocket.accept();
            String ip = client.getInetAddress().getHostAddress();
            System.out.println("ip"+ip+"connected");
            /*一定不能漏掉true，否则网页会打不开*/
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            out.println("客户端你好");




       client.close();
       serverSocket.close();
    }
}
