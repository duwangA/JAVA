package day19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
* 缓冲区的出现是为了提高流操作的效率
* 所以在创建缓冲区之前，必须先有流对象
* */
public class BufferDemo {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("buf.txt");
        } catch (IOException e) {
            try {
                fileWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        //只需要将需要提高效率的流对象作为参数传递给缓冲区的构造函数即可
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {
            for (int x = 1; x<5;x++){
            bufferedWriter.write("abcde"+x);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
//                fileWriter.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
