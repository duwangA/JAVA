package day24;

import java.util.TreeSet;

public class RegexTest {
    public static void test_1(){
        String string = "我我...我我...要要...要要...学..学学....学学...学..编...编..编编..程...程..程程..程";

        string = string.replaceAll("\\.+","");
        System.out.println(string);
        string = string.replaceAll("(.)\\1+","$1");
        System.out.println(string);
    }
    public static void test_2(){
        String ip = "192.168.1.1 102.49.23.12 10.10.10.10 8.109.90.30";
        ip = ip.replaceAll("(\\d+)","00$1");
        System.out.println(ip);

        ip = ip.replaceAll("0*(\\d{3})","$1");
        System.out.println(ip);

        String[] arr = ip.split(" ");

        TreeSet<String> treeSet = new TreeSet<String>();

        for (String s: arr
             ) {
            treeSet.add(s);
        }
        for (String s: treeSet
             ) {
            System.out.println(s);
        }
    }

    public static void checkMail(){
        String mail =  "abc123@sina.com.cn";

        String reg = "[a-zA-Z0-9_]{6,12}@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";
        /*@前保证6-12字母数字下划线，后面保证字母数字，+ 即一个或多个，后面.xxx封装成组，因为有可能出来多个.xxx.xxx的邮箱*/
        System.out.println(mail.matches(reg));
    }
    public static void main(String[] args) {
//        test_1();
//        test_2();
        checkMail();
    }
}
