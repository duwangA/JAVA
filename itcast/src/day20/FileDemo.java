package day20;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
//        consMethod();
//        judgeMethod();
        method4();
    }

    public static void method4() throws IOException {
        File file = new File("a.txt");

        sop("path--"+file.getPath());
        sop("abspath"+file.getAbsolutePath());
        sop("Canpath"+file.getCanonicalPath());
    }
    public static void judgeMethod(){

        File file = new File("a.txt");

        //在做判断是否为文件或者文件夹时，必须先判断是否存在
        sop("exists:"+file.exists());
        sop("dir--"+file.isDirectory());
        sop("file--"+file.isFile());
    }
    public static void consMethod() throws IOException {
        //将a.txt封装成file对象
        File file = new File("a.txt");

        //创建文件夹
        File dir = new File("测试创建目录");

//        sop("mkdir = "+dir.mkdir()); /*该方法只能创建一级目录*/

//        sop("create:::"+file.createNewFile());//创建文件，创建成功返回ture，如果文件创建前存在，返回flase
        sop(file.exists());
    }
    public static void sop(Object object){
        System.out.println(object);
    }
}
