package day23;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
* 需求:多个客户端并发访问
* */
public class UpLoadByThread {
}

class PicThread implements Runnable{
    private Socket socket;

    PicThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        String ip = socket.getInetAddress().getHostAddress();
//        int count = 0;
        try {

            System.out.println("ip"+ip+"has connected...");
            InputStream inputStream = socket.getInputStream();
            //使用时间戳命名，保证不重复
            Long time = System.currentTimeMillis();
            File file = new File(String.valueOf(time)+".jpg");
            /*
                        File file = new File(ip+"("+(count)+")".jpg");
                        while(file.exist())
                            File file = new File(ip+"("+(count++)+")".jpg");
            * */
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf))!=-1){
                fileOutputStream.write(buf,0,len);
            }

            OutputStream out = socket.getOutputStream();
            out.write("上传成功".getBytes());

            fileOutputStream.close();
            socket.close();
        }catch (Exception exception){
            throw new RuntimeException(ip+"上传失败");
        }
    }
}
class ClientuploadByThread{
    public static void main(String[] args) throws Exception {
        System.out.println("请输入文件路径");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String pathname = bufferedReader.readLine();
        System.out.println(pathname);
        File file = new File(pathname);

        if (!(file.exists() && file.isFile()))
        {
            System.out.println("该文件不存在或者不是文件");
            return;
        }
        if (!(file.getName().endsWith(".jpg")))
        {
            System.out.println("图片格式错误，请重新选择");
            return;
        }
        if (file.length() > 1024*1024*5)
        {
            System.out.println("文件过大，没安好心");
        }
        Socket socket = new Socket("169.254.160.34",8888);

        FileInputStream fileInputStream = new FileInputStream(file);

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

class ServeruploadByThread{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket client = serverSocket.accept();

            new Thread(new PicThread(client)).start();
        }
//        serverSocket.close();
    }
}