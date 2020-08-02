package day19;

import java.io.*;

class MyBufferedInputStream{
    private InputStream in;
    private byte[] buf = new byte[1024];
    private int pos=0,count=0;
    MyBufferedInputStream(InputStream in){
        this.in = in;
    }
    public int myRead() throws IOException {

        if (count == 0){

            count=in.read(buf);
            if (count<0)
                return -1;
            pos=0;
            byte b = buf[pos];
            count--;
            pos++;
            return b&255;
        }
        else if (count>0){
            byte b = buf[pos];

            count--;
            pos++;
            return b&255;//byte型升级int型，为了防止出现-1，与即可，int32位，byte8位，后的write会强转为byte，所以大小不变
        }
        return -1;
    }
    public void myClose() throws IOException{
        in.close();
    }
}
public class BufferDemo4 {
    public static void main(String[] args) throws IOException{
        MyBufferedInputStream myBufferedInputStream = new MyBufferedInputStream(new FileInputStream("doa.flac"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("doacopy.flac"));

        int by = 0;

        while ((by=myBufferedInputStream.myRead())!=-1){
            bufferedOutputStream.write(by);
        }
        myBufferedInputStream.myClose();
        bufferedOutputStream.close();
    }
}
