package day18;

import java.util.Properties;

public class SystemDemo {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.setProperty("my key","my value");

        for (Object obj: properties.keySet()
             ) {
            String value = (String) properties.get(obj);

            System.out.println(obj+"::"+value);
        }
    }
}
