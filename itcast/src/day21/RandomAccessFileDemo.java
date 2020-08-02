package day21;

import java.io.IOException;
import java.io.RandomAccessFile;

/*该类只能操作文件，且还有模式的限制*/
/*该类可以修改已存在的内容，不会覆盖，这是与流操作的区别*/
/*该类多线程操作既可以是下载的原理*/
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
//        writeFile();
//        readFile();
        writeFile_2();
    }

    public static void readFile() throws  IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("raf.txt","r");//只读

        //调整该对象的指针
        randomAccessFile.seek(10);
        byte[] buf = new byte[6];

        randomAccessFile.read(buf);
        String s = new String(buf);

        int age = randomAccessFile.readInt();

        System.out.println("name"+s);
        System.out.println("age"+age);
        randomAccessFile.close();
    }

    public static void writeFile_2() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("raf.txt","rw");//读写

        randomAccessFile.seek(10*3);

        randomAccessFile.write("周期".getBytes());
        randomAccessFile.writeInt(103);

        randomAccessFile.close();
    }
    public static void writeFile() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("raf.txt","rw");//读写

        randomAccessFile.write("李四".getBytes());
//        randomAccessFile.write(97);//不可以超过255 只有八位
        randomAccessFile.writeInt(97);//四个字节，32位

        randomAccessFile.write("王五".getBytes());
        randomAccessFile.writeInt(99);

        randomAccessFile.close();
    }
}
