package day24;

/*
* 正则表达式
* 作用：用于专门操作字符串
* 特点：用一些特定的符号来表示一些代码的操作，简化书写
* 好处：简化对字符串的复杂操作
* 坏处：阅读性极差
* 具体功能：
* 1 匹配 String类的 matches方法
* 2 切割 String类的 split方法
* 3 替换 String类的 replace方法
* */

public class RegexDemo {
    public static void main(String[] args) {
//        checkQQ();
//        REGEXcheck();
//        splitDemo("ssssfggggegdfdsvvdfefddfg","(.)\\1+");//按照叠词切割
        /*为了让规则可被重用，可用()将规则封装成一个组，组的出现都有编号，从1开始，想要使用已有的组，可以通过\n的形式获取，n即组的编号，左括号第几个就是第几组*/
    String str = "fgh123451242sgwefdshs245sf5da4s5f12sdsa";
    replaceALLDemo(str,"\\d{5,}","#");//将字符串的数字替换成#
    String str1 = "eeeeeegdggghdgyyydgddt";
    replaceALLDemo(str1,"(.)\\1+","$1");//$可以获取正则中的组
    }
    public static void replaceALLDemo(String oldS, String reg, String newS){

        oldS = oldS.replaceAll(reg,newS);

        System.out.println(oldS);
    }
    public static void splitDemo(String str, String reg){

        String[] arr = str.split(reg);
        System.out.println(arr.length);

        for (String s: arr
             ) {
            System.out.println(s);
        }
    }
    /*正则表达式*/
    public static void REGEXcheck(){
        String qq = "123456";

        String regex = "[1-9][0-9]{4,14}";
        boolean flag = qq.matches(regex);

        if (flag)
            System.out.println(qq + "is ok");
        else
            System.out.println("nonononono");
    }
    /*String类方法校验，过于繁琐*/
    public static void checkQQ(){
        String qq = "12345";

        int len = qq.length();

        if (len>=5 && len <=15)
        {
            if (!qq.startsWith("0"))
            {

                try {
                    long l = Long.parseLong(qq);
                    System.out.println("qq="+qq);
                } catch (NumberFormatException e) {
                    System.out.println("出现非法字符");
                }

                /*char[] arr = qq.toCharArray();
                boolean flag = true;
                for (int x = 0; x<arr.length;x++)
                {
                    if (!(arr[x] >='0' && arr[x] <= '9'))
                    {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                {
                    System.out.println("QQ:"+qq);
                }
                else
                {
                    System.out.println("QQ号出现非法字符");
                }*/

            }
            else
            {
                System.out.println("不可以零开头");
            }
        }
        else
        {
            System.out.println("长度有误");
        }
    }
}
