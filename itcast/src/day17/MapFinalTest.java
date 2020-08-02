package day17;

import java.util.HashMap;
import java.util.Iterator;

public class MapFinalTest {
    public static void main(String[] args) {
        HashMap<String,String> yure = new HashMap<String,String>();
        yure.put("01","张三");
        yure.put("02","李四");

        HashMap<String,String> jiuye = new HashMap<String,String>();
        jiuye.put("01","王五");
        jiuye.put("02","赵六");

        HashMap<String,HashMap<String,String>> itcast = new HashMap<String,HashMap<String,String>>();
        itcast.put("预热班",yure);
        itcast.put("就业班",jiuye);
        Iterator<String> iterator =itcast.keySet().iterator();
        while (iterator.hasNext()){
            String roomname = iterator.next();

            HashMap<String,String> xueyuan = itcast.get(roomname); //该方法根据key获取value

            System.out.println(roomname);
            getStudentInfo(xueyuan);
        }

//        getStudentInfo(yure);
//        getStudentInfo(jiuye);
    }
    public static void getStudentInfo(HashMap<String,String> roomMap){
        Iterator<String> iterator=roomMap.keySet().iterator();

        while (iterator.hasNext()){
            //id是key，name是value
           String id = iterator.next();

           String name = roomMap.get(id);

           System.out.println(id+":"+name);
        }
    }
}
