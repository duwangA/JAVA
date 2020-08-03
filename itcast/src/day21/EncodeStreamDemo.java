package day21;

import java.io.*;

public class EncodeStreamDemo {
    public static void main(String[] args) throws IOException {
//        writeText();
        readText();
    }

    public static void readText() throws IOException {
        InputStreamReader inputStreamReader= new InputStreamReader(new FileInputStream("GBK.txt"),"UTF-8");

        char[] buf = new  char[10];
        int len = inputStreamReader.read(buf);

        String string = new String(buf,0,len);

        System.out.println(string);

        inputStreamReader.close();
    }
    public static void writeText() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("GBK.txt"),"GBK");

        outputStreamWriter.write("你好");

        outputStreamWriter.close();
    }
}
