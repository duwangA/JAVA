package day24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 正则表达式的获取：将字符串中符合规则的子串取出
*
* 操作步骤
* 1 将正则表达式封装成对象
* 2 让正则表达式与被操作字符串关联
* 3 获取正则匹配引擎
* 4 通过引擎对符合规则的子串操作
* */
public class RegexDemo2 {
    public static void main(String[] args) {
        getDemo();
    }
    public static void getDemo(){
        String string = "ming tian jiu yao jie shu le。";

        String reg = "\\b[a-z]{3}\\b";
        //将规则封装成对象
        Pattern pattern = Pattern.compile(reg);

        //让正则对象和要操作的字符串关联，获取匹配器对象
        Matcher matcher = pattern.matcher(string);

//        boolean b = matcher.find();//将规则作用到字符串上，并进行符合规则的子串查找
//        System.out.println(b);
//        System.out.println(matcher.group());//获取匹配后的字符串
        /*先找再取*/
        while (matcher.find()){
            System.out.println(matcher.group());
        }



    }
}
