package day23;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
* 需求:   建立一个文本转换服务器
* 客户端给服务端发送文本，服务端将文本转成大写返回给客户端
* 客户端可以不断发送文本让服务端转换，当客户端输入over，转换结束
* */
public class TCPtestDemo {

}
class TcpTestClient{
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("169.254.160.34",8888);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        /*PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true)*/

        BufferedReader ServerbufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //发送数据
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            if ("over".equals(line))
                break;
            bufferedWriter.write(line);//这里write方法发送数据是不带回车符的，不加回车符Server类的循环判定就会永远等待
            bufferedWriter.newLine();
            bufferedWriter.flush();
            /*out.println(line),服务端输出流也可用此法*/
            String Serverline= ServerbufferedReader.readLine();//同上判定
            System.out.println("Server:"+Serverline);

        }
        //接收数据


        /*String Serverline = null;
        while ((Serverline= ServerbufferedReader.readLine()) != null){
            System.out.println(Serverline);
        }*/
        bufferedReader.close();
        clientSocket.close();
    }
}

class TransServer{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket client = serverSocket.accept();

        BufferedReader clientBufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter cilentBufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String clientdata = null;
        String ip = client.getInetAddress().getHostAddress();
        System.out.println("ip="+ip+"has connected!");
        while ((clientdata = clientBufferedReader.readLine())!= null){
            System.out.println(clientdata);

            cilentBufferedWriter.write(clientdata.toUpperCase());
            cilentBufferedWriter.newLine();
            cilentBufferedWriter.flush();
        }
        client.close();
    }


}