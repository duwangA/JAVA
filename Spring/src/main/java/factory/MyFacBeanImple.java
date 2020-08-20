package factory;

import bean.Book;
import org.springframework.beans.factory.FactoryBean;

/**
 * 实现了该接口的类是Spring可以识别的工厂类
 * Spring会自动调用工厂方法创建实例
 * @author duwanga
 */
public class MyFacBeanImple implements FactoryBean<Book> {
    /**
     * 工厂方法，返回创建的对象
     * @return
     * @throws Exception
     * ioc容器启动的时候不会创建实例，只有获取的时候才会创建实例（无论是单例还是多例，在isSingle方法设置）
     *
     */
    @Override
    public Book getObject() throws Exception {
        System.out.println("myFac创建对象开始...");
        Book book = new Book();

        book.setBookName("小王子");
        book.setIssues("xx出版社");
        book.setPrice("12");

        return book;
    }

    /**
     * 返回创建对象的类型
     * Spring会自动调用这个方法来确认创建对象的所属类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    /**
     * 是单例吗？
     * @return
     */
    @Override
    public boolean isSingleton() {
        //设定为flase:非单例；ture：多例
        return false;
    }
}
