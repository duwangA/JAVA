package day19;

import java.io.*;

public class BufferDemo3 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("src/day19/BufferDemo.java"));
        } catch (FileNotFoundException e) {
            try {
                bufferedReader.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("bufferWriterClone.txt"));
        } catch (IOException e) {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        String readline = null;

            try {
                while ((readline=bufferedReader.readLine())!=null){
                bufferedWriter.write(readline);     //写入数据
                bufferedWriter.newLine();           //换行
                bufferedWriter.flush();             //刷新缓存
                 }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (bufferedReader!=null)
                        bufferedReader.close();
                    if (bufferedWriter!=null)
                        bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }
}
