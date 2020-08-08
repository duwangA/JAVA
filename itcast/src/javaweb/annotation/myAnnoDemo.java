package javaweb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE})//表示该注解只能作用于类上
@Retention(RetentionPolicy.RUNTIME)//作用阶段
public @interface myAnnoDemo {
}
