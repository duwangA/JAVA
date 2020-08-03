package day21;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {
    public static void main(String[] args)  throws IOException {

        //源
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("ABCDDFEF".getBytes());
        //目的
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int by = 0;

        while ((by = byteArrayInputStream.read())!= -1){
            byteArrayOutputStream.write(by);
        }

        System.out.println(byteArrayOutputStream.size());
        System.out.println(byteArrayOutputStream.toString());

        byteArrayOutputStream.writeTo(new FileOutputStream("ByteDemo.txt"));
    }
}
