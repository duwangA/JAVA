package day24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*网页爬虫*/
public class RegexTest2 {
    public static void main(String[] args) {

    }
    /*
    * 获取指定文档中的邮件地址
    * 使用获取功能
    * */
    public static void getMailsfromWeb(URL url) throws Exception {
        URLConnection con = url.openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String line = null;
        //正则表达式
        String regex = "[a-zA-Z0-9_]{6,12}@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";
        Pattern pattern = Pattern.compile(regex);


        while ((line = bufferedReader.readLine())!=null)
        {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find())
            {
                System.out.println(matcher.group());
            }
        }
    }
    public static void getMails() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("mail.txt"));

        String line = null;
        //正则表达式
        String regex = "[a-zA-Z0-9_]{6,12}@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";
        Pattern pattern = Pattern.compile(regex);


        while ((line = bufferedReader.readLine())!=null)
        {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find())
            {
                System.out.println(matcher.group());
            }
        }
    }
}
