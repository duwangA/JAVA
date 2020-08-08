package javaweb.annotation;

import javax.xml.bind.Element;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述要执行的类名和方法名
 * 之后在需要取注解内容的类上，获取字节码文件对象，里面有getAnnotation方法可以获取到注解对象
 * 其实就是在内存中生成了一个该注解接口的子类实例对象
 * public class ProImpl implements Pro{
 *     public String className(){return ""};
 *     public String methodName(){return ""};
 * }
 * 调用注解定义的抽象方法获取返回值，自定义注解里面全是抽象方法
 */
@Target({ElementType.TYPE}) //作用于类上
@Retention(RetentionPolicy.RUNTIME) //保留在运行时阶段
public @interface Pro {
    String className();
    String methodName();
}
