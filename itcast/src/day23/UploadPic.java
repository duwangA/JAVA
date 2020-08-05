package day23;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPic {
}

class Clientupload{
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("169.254.160.34",8888);

        FileInputStream fileInputStream = new FileInputStream("1.jpg");

        OutputStream outputStream = socket.getOutputStream();
        byte[] buf = new byte[1024];

        int len = 0;

        while ((len = fileInputStream.read(buf)) != -1){
            outputStream.write(buf,0,len);
        }
        //通知服务端数据传输完了
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] bufin = new byte[1024];

        int num = inputStream.read(bufin);
        System.out.println(new String(bufin,0,num));

        fileInputStream.close();
        socket.close();
    }
}

class Serverupload{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket client = serverSocket.accept();

        String ip = client.getInetAddress().getHostAddress();
        System.out.println("ip"+ip);
        InputStream inputStream = client.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buf))!=-1){
            fileOutputStream.write(buf,0,len);
        }

        OutputStream out = client.getOutputStream();
        out.write("上传成功".getBytes());

        fileOutputStream.close();
        client.close();
        serverSocket.close();
    }
}
