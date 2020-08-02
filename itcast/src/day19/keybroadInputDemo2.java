package day19;

import java.io.*;

public class keybroadInputDemo2 {
    public static void main(String[] args) throws IOException {
        /*源*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));/*字节流转换字符流，即该类为转换流*/
        /*目的*/
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));/*输入到控制台*/
        String readline = null;

        while ((readline = bufferedReader.readLine()) != null){
            if ("over".equals(readline))
                break;
            bufferedWriter.write(readline.toUpperCase());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedReader.close();
    }
}
