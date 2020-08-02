package day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
public class youhua {
    public static void Demo() {
    HashMap<String, List<xuesheng>>  czbk = new HashMap<String, List<xuesheng>>();

    List<xuesheng> yure = new ArrayList<xuesheng>();
    List<xuesheng> jiuye = new ArrayList<xuesheng>();

    czbk.put("预热班",yure);
    czbk.put("就业班",jiuye);
    yure.add(new xuesheng("01","张三"));
    yure.add(new xuesheng("02","李四"));
    jiuye.add(new xuesheng("01","王五"));
    jiuye.add(new xuesheng("02","赵六"));

    Iterator<String> it = czbk.keySet().iterator();

    while(it.hasNext()){
        String roomName = it.next();
        List<xuesheng> room = czbk.get(roomName);

        System.out.println(roomName);
        getinfo(room);
    }

}
public static void getinfo(List<xuesheng> list){
        Iterator<xuesheng> iterator = list.iterator();
        while (iterator.hasNext()){
            xuesheng s = iterator.next();
            System.out.println(s);
        }
    }

public static void main(String[]args){
        Demo();
        }
}

class xuesheng{
    private String id;
    private String name;

    xuesheng(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){
        return id+"-----"+name;
    }
}
