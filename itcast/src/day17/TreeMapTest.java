package day17;

import java.util.*;

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1,Student student2) {
        int num = student1.getName().compareTo(student2.getName());
        if(num == 0)
            return new Integer(student1.getAge()).compareTo(student2.getAge());
        return num;
    }
}
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Student,String> treeMap = new TreeMap<Student,String>(/*new StudentComparator()*/);
        treeMap.put(new Student("a李四4",24),"武汉");
        treeMap.put(new Student("李四1",21),"北京");
        treeMap.put(new Student("b李四3",23),"南京");
        treeMap.put(new Student("李四2",22),"上海");

        Set<Map.Entry<Student,String>> entrySet= treeMap.entrySet();
        Iterator<Map.Entry<Student,String>> iterator = entrySet.iterator();

        while (iterator.hasNext()){
            Map.Entry<Student,String> mp = iterator.next();
            Student student = mp.getKey();
            String address = mp.getValue();
            System.out.println(student+":"+address);

        }
    }
}
