package javaweb.test;

import javaweb.junit.CalculatorDemo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 初始化方法，一般用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * 释放资源的方法，在所有测试方法执行完后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close...");
    }
    /**
     * 测试add方法
     */
    @Test
    public void testAdd(){
//        System.out.println("我被执行啦");
//        创建计算器对象--> 调用add方法
        CalculatorDemo calculatorDemo = new CalculatorDemo();
        int result = calculatorDemo.add(1,2);

//        System.out.println(result);
//        断言 如：我断言这个结果肯定为3，程序会与断言比对
        Assert.assertEquals(3,result);//第一位是期望值，第二位是真实值
    }
}
