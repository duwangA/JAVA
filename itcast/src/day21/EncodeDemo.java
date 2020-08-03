package day21;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class EncodeDemo {
    public static void main(String[] args) throws IOException {
        String s = "你好";

        byte[] bytes = s.getBytes();

        System.out.println(Arrays.toString(bytes));

//        byte[] bytess = s.getBytes("GBK");
//        System.out.println(Arrays.toString(bytess));

        String s1 = new String(bytes,"ISO8859-1");
        System.out.println(s1);

        //重新编码编回去，再按正确解码方式解
        byte[] b2 = s1.getBytes("ISO8859-1");
        System.out.println(Arrays.toString(b2));

        String s2 = new String(b2,"UTF-8");
        System.out.println(s2);
    }
}
