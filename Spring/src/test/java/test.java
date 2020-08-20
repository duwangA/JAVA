import bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * ioc测试类
 */
public class test {


    @Test
    public void iocTest05() throws SQLException {
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
        //通过类型获取组件，可以获取到该类的所有实现类子类，
        DataSource bean = ioc.getBean(DataSource.class);
        System.out.println(bean.getConnection());
    }
    @Test
    public void iocTest04(){
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("ioc2.xml");
//        System.out.println(applicationContext2.getBean("airplane01"));
//        System.out.println("容器启动完成...");

        System.out.println(applicationContext2.getBean("myFacBeanImple"));
    }

    /**
     * 通过属性名获取对象
     */
    @Test
    public void iocTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Person beanFirst = (Person) applicationContext.getBean("Person01");
        System.out.println(beanFirst);
    }

    /**
     * 通过类型获取(一个)对象
     * 如果ioc容器中bean超过一个，会抛出异常
     */
    @Test
    public void iocTest02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
    }

    /**
     * 重要!
     * 采用有参构造器创建赋值并获取对象
     *
     */
    @Test
    public void iocTest03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        System.out.println(applicationContext.getBean("Person02"));
        System.out.println(applicationContext.getBean("Person03"));
    }

}
