package day17;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest3 {
    public static String charCount(String str){
        char[] chars = str.toCharArray();

        TreeMap<Character,Integer> treeMap = new TreeMap<Character,Integer>();

        for (int x=0; x < chars.length; x++){
            Integer value = treeMap.get(chars[x]);

            if(value == null) {
                treeMap.put(chars[x], 1);
            }
            else{
                value++;
                treeMap.put(chars[x],value);
            }
        }
//        System.out.println(treeMap);

        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<Character,Integer>> entrySet = treeMap.entrySet();
        Iterator<Map.Entry<Character,Integer>> iterator = entrySet.iterator();

        while (iterator.hasNext()){
            Map.Entry<Character,Integer> mp = iterator.next();
            Character character = mp.getKey();
            Integer integer = mp.getValue();
            stringBuilder.append(character+"("+integer+")");
        }

        return stringBuilder.toString();
    }
    public static void main(String[] args) {

        System.out.println(charCount("aasafffffskdsssf"));
    }
}
