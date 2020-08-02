package day21;

import java.io.*;

/*ObjectOutputStream将Java对象的原始数据类型和图形写入OutputStream。只能对堆里的对象序列化
可以使用ObjectInputStream读取（重构）对象。 可以通过使用流的文件来实现对象的持久存储。
        如果流是网络套接字流，则可以在另一个主机上或另一个进程中重构对象。 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, SecurityException,ClassNotFoundException{
//        writeObj();
        readObj();
    }

    public static void readObj() throws IOException ,ClassNotFoundException{
        ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream("obj.txt"));

        PersonDemo personDemo =(PersonDemo) objectOutputStream.readObject();//默认返回为Object类型

        System.out.println(personDemo);
        objectOutputStream.close();
    }

    public static void writeObj() throws IOException , SecurityException{
        /*目的:将对象写到一个文件里*/
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("obj.txt"));

        objectOutputStream.writeObject(new PersonDemo("zhangsan",39));//将指定对象写入流对象

        objectOutputStream.close();
    }
}
