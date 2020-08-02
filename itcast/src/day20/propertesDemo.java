package day20;

import java.io.*;
import java.util.Properties;

public class propertesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        File file = new File("count.ini");//封装文件
        if (!file.exists())
            /*不存在则创建配置文件*/
            file.createNewFile();

        FileInputStream fileInputStream = new FileInputStream("count.ini");//与流相关联
        /*将流中数据加载进properties集合*/
        properties.load(fileInputStream);
        /*通过键拿值*/
        int count = 0;
        String value = properties.getProperty("time");

        if (value!=null) {
            count = Integer.parseInt(value);

            if(count>=5) {
                System.out.println("使用次数不足，拿钱！");
                return ;
            }
        }
        count++;
        /*增加完后存入集合*/
        properties.setProperty("time",count+""/*转换成字符型*/);
        /*重新写入文件，创建输出流*/
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        /*将集合中数据写入与输出流关联的文件*/
        properties.store(fileOutputStream,"");

        fileOutputStream.close();
        fileInputStream.close();
    }
}
