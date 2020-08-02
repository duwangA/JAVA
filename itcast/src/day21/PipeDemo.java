package day21;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Read implements Runnable{
    private PipedInputStream pipedInputStream;

    Read(PipedInputStream pipedInputStream){
        this.pipedInputStream = pipedInputStream;
    }
    @Override
    public void run() {
        try {
            byte[] bytes = new byte[1024];
            //流对象往数组里写数据
            int length = pipedInputStream.read(bytes); //未接收到数据时线程阻塞
            //将数据转换成字符型
            String s = new String(bytes,0,length);
            System.out.println(s);
            pipedInputStream.close();
        }
        catch (IOException e){
            throw new RuntimeException("管道读取流失败");
        }
    }
}

class Write implements Runnable{
    private PipedOutputStream pipedOutputStream;

    Write(PipedOutputStream pipedOutputStream){
        this.pipedOutputStream = pipedOutputStream;
    }
    @Override
    public void run() {
        try {
            pipedOutputStream.write("管道读取流创建成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class PipeDemo {
    public static void main(String[] args) throws IOException{
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        Read read = new Read(pipedInputStream);
        Write write = new Write(pipedOutputStream);

        pipedInputStream.connect(pipedOutputStream);

        new Thread(read).start();
        new Thread(write).start();
    }

}
