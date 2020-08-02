package day18;

import java.io.FileWriter;
import java.io.IOException;

/*
* 字符流和字节流
*                读取         写入
* 字节流两个基类: InputStream OutputStream
*               读取      写入
* 字符流两个基类: Reader Writer
* FileWriter 操作文件的Writer子类对象
* */
public class IODemo {
    public static void main(String[] args) {
        //创建一个FileWriter对象引用，以便finally块能关闭流
        FileWriter fileWriter = null;
        try {//try内再初始化

            fileWriter = new FileWriter("demo.txt");
            fileWriter.write("wdnmd");
            //调用write方法后，数据在缓冲区中，并未直接体现在文件上，此时应该刷新缓冲(临时存放数据的地方)，使数据到达目标位置
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            //此异常可处理FileNotFoundException，因为是IOException的子类
        }
        finally {
            //必须执行的操作，关闭流，关闭前会刷新缓冲，此时无法再操作该流对象
             try {//close也会抛异常
                        if(fileWriter != null) //空的无法close，提高代码健壮性
                            fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
        }

    }
}
