package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        binarySearchDemo();
    }

    public static void binarySearchDemo(){
        List<String> list = new ArrayList<String>();

        list.add("aaa");
        list.add("abc");
        list.add("dsada");
        list.add("zzzz");
        list.add("lol");

//        Collections.fill(list,"gg");
        Collections.replaceAll(list,"abc","fk");
        Collections.sort(list);
        System.out.println(list);

        int index = Collections.binarySearch(list,"zzzz");
        System.out.println("index="+index);
    }
}
