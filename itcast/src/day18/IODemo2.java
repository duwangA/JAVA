package day18;

import java.io.FileWriter;
import java.io.IOException;

/*
*对已有文件的数据续写
* */
public class IODemo2 {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("demo.txt",true);
            fileWriter.write("\rgun");//添加到文件的末尾 \r为windows换行符，\n为linux下的换行

            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
