package day18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOdemo3 {
    public static void main(String[] args) {
            FileReader fileReader = null;
        try {
            //创建文件读取流对象，和指定名称的文件相关联，如果文件不存在，会抛出FileNotFoundException
            fileReader = new FileReader("demo.txt");

            try {
                int ch = 0;
                while ((ch = fileReader.read())!= -1){
                    System.out.println("ch="+(char)ch);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
