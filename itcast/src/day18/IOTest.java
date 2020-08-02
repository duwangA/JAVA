package day18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args) throws IOException{
        //cloneTxt();
        bufferClone();
    }

    public static void bufferClone() throws IOException {
        FileWriter fileWriter = new FileWriter("IODemoCopy2.java");
        FileReader fileReader = new FileReader("src/day18/IODemo.java");

        char[] buffer = new char[1024];

        int length = 0;
        while ((length = fileReader.read(buffer)) != -1){
            fileWriter.write(buffer,0,length);
        }
        fileWriter.close();
        fileReader.close();
    }
    public static void cloneTxt() throws IOException {
        //创建目的地
        FileWriter fileWriter = new FileWriter("IODemoCopy.txt");

        //与已有文件关联
        FileReader fileReader = new FileReader("src/day18/IODemo.java");

        int ch= 0;

        while ((ch = fileReader.read()) != -1){
            fileWriter.write(ch);

            fileWriter.flush();
        }
        fileWriter.close();
        fileReader.close();
    }
}
