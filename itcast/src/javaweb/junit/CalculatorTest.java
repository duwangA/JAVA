package javaweb.junit;

public class CalculatorTest {
    public static void main(String[] args) {
         // 创建对象
        CalculatorDemo calculatorDemo = new CalculatorDemo();

        int result = calculatorDemo.add(1,2);
        System.out.println(result);
    }
}
