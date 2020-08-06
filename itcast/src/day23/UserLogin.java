package day23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class LoginClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("169.254.160.34",8888);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        BufferedReader bufIn =new BufferedReader(new InputStreamReader(socket.getInputStream()));

        for (int x = 0; x<3;x++)
        {
            String line = bufferedReader.readLine();
            if(line == null)
                break;
            out.println(line);

            String info = bufIn.readLine();

            System.out.println("Info:"+info);
            if (info.contains("欢迎")){
                break;
            }
        }
        bufferedReader.close();
        socket.close();
    }
}
class LoginServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);


        while (true){
            Socket client = serverSocket.accept();

            new Thread(new UserThread(client)).start();
        }
    }
}
class UserThread implements Runnable{
    private Socket socket;
    UserThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip+"connected");
        try {
            for (int x = 0; x<3 ; x++)
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String name = bufferedReader.readLine();

                if (name == null)
                    break;

                BufferedReader bufrf = new BufferedReader(new FileReader("user.txt"));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                String line = null;

                boolean flag = false;
                while ((line = bufrf.readLine()) != null){
                    if (line.equals(name)){
                        flag = true;
                        break;
                    }
                }
                if (flag)
                {
                    System.out.println(name+"登陆成功");
                    out.println(name+"欢迎光临");
                    break;//退出三次校验
                }
                else{
                    System.out.println(name+"尝试登陆");
                    out.println("用户名不存在");
                }
            }
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(ip+"校验失败");
        }
    }
}