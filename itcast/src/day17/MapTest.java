package day17;

import java.util.*;

class Student implements Comparable<Student>{
    private String name;
    private int age;

    Student(String name,int age){
        setName(name);
        setAge(age);

    }
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return name+":"+age;
    }
    //存入Set使用
    public int hashCode(){
        return name.hashCode()+age*33;
    }
    //存入Set使用
    public boolean equals(Object o) {
        if(!(o instanceof Student)){
            throw  new ClassCastException("类型不匹配");
        }
        Student s = (Student)o;

        return this.name.equals(s.name) && this.age == s.age;
    }
    //存入二叉树使用
    public int compareTo(Student student){
        int num = new Integer(this.age).compareTo(new Integer(student.age));
        if(num == 0)
            return this.name.compareTo(student.name);
        return num;
    }
}

public class MapTest {
    public static void main(String[] args) {
        Map<Student,String> hashMap = new HashMap<Student,String>();

        hashMap.put(new Student("李四1",21),"北京");
        hashMap.put(new Student("李四2",22),"上海");
        hashMap.put(new Student("李四3",23),"南京");
        hashMap.put(new Student("李四4",24),"武汉");

//        Set<Student> keySet = hashMap.keySet();
//        Iterator<Student> it = keySet.iterator();
//
//        while (it.hasNext()){
//            Student student = it.next();
//            System.out.println(student+":"+hashMap.get(student));
//        }
        Set<Map.Entry<Student,String>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<Student,String>> iterator = entrySet.iterator();

        while (iterator.hasNext()){
            Map.Entry<Student,String> mp = iterator.next();
            Student student = mp.getKey();
            String addrress = mp.getValue();
            System.out.println(student+"-------"+addrress);
        }
    }
}
