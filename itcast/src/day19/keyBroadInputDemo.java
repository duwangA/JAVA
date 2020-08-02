package day19;

import java.io.IOException;
import java.io.InputStream;

/*
* 键盘输入
* System.in
* */
public class keyBroadInputDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;//读取键盘输入
        StringBuilder stringBuilder = new StringBuilder();

       while (true){
           int ch = inputStream.read();

           if (ch == '\r')
               continue;
           if (ch == '\n'){
               String s = stringBuilder.toString();
               if ("over".equals(s)){
                   break;
               }
               System.out.println(s.toUpperCase());
               //每次输出后清空缓冲区
               stringBuilder.delete(0,stringBuilder.length());
           }
           else
                stringBuilder.append((char) ch);
       }
    }
}
