package day17;

import java.util.*;

public class MapDemo {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<String, String>();

        //添加元素
        map.put("01","zhangsan1");
        map.put("02","zhangsan2");
        map.put("03","zhangsan3");

        Set<Map.Entry<String,String>> entrySet = map.entrySet(); //该方法取出映射关系

        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();//Set集合的迭代器，然后使用该类型迭代器特有方法获取k，v
        while (iterator.hasNext()){
            Map.Entry<String,String>Me = iterator.next();
            String key = Me.getKey();
            String value = Me.getValue();
//            System.out.println(Me);
            System.out.println(key+":"+value);
        }
//        System.out.println("containsKey:"+map.containsKey("02"));
//        System.out.println("remove:"+map.remove("02"));
//        System.out.println(map);
//        System.out.println(map.values());
//        Collection<String> coll = map.values();
//        System.out.println(coll);
//        Set<String> keySet = map.keySet();
//        Iterator<String> it = keySet.iterator();
//
//        while (it.hasNext()) {
//        String key = it.next();
//        System.out.println("key:"+key);
//        String value = map.get(key);
//        System.out.println(value);
//        }
    }
}
