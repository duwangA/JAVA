package day21;

import java.io.Serializable;
//transient关键字:保证成员只在堆中存在而不长久保存
//该接口无方法，为标记接口,产生序列号，成员不变序列号则相同
class PersonDemo implements Serializable {
    String name;
    int age;

    PersonDemo(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String toString(){
        return name+":"+age;
    }
}
