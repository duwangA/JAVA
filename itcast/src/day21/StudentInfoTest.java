package day21;


import java.io.*;
import java.util.*;

class Student implements Comparable<Student>{
    private String name;
    private int maths,chinese,english;
    private int sum;

    Student(String name, int maths, int chinese, int english){
        setChinese(chinese);
        setEnglish(english);
        setMaths(maths);
        setName(name);
        sum = maths + english + chinese;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getChinese() {
        return chinese;
    }

    public int getEnglish() {
        return english;
    }

    public int getMaths() {
        return maths;
    }

    public int getSum() {
        return sum;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return maths == student.maths &&
                chinese == student.chinese &&
                english == student.english &&
                sum == student.sum &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maths, chinese, english, sum);
    }

    @Override
    public int compareTo(Student s) {

        int num = new Integer(this.sum).compareTo(new Integer(s.sum));

        if(num == 0)
            return this.name.compareTo(s.name);
        return num;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", maths=" + maths +
                ", chinese=" + chinese +
                ", english=" + english +
                ", sum=" + sum +
                '}';
    }
}

class StudentInfoTool{
    public static Set<Student> getStudents() throws IOException {
           return getStudents(null);
    }

    public static Set<Student> getStudents(Comparator<Student> comparator) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        Set<Student> students = null;
        if (comparator == null)
            students = new TreeSet<Student>();
        else
            students = new TreeSet<Student>(comparator);
        while ((line = bufferedReader.readLine()) != null)
        {
            if ("over".equals(line))
                break;
            String[] info = line.split(",");

            Student student = new Student(info[0],Integer.parseInt(info[1]),
                    Integer.parseInt(info[2]),Integer.parseInt(info[3]));

            students.add(student);
        }

        bufferedReader.close();

        return students;
    }

    public static void writeToFile(Set<Student> stu) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt"));

        for (Student student : stu){
            bufferedWriter.write(student.getName()+"\t");
            bufferedWriter.write(student.getMaths()+"\t");
            bufferedWriter.write(student.getChinese()+"\t");
            bufferedWriter.write(student.getEnglish()+"\t");
            bufferedWriter.write(student.getSum()+"\t");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
    }
}
public class StudentInfoTest {
    public static void main(String[] args) throws IOException {
        Comparator<Student> studentComparator = Collections.reverseOrder();
        Set<Student> students = StudentInfoTool.getStudents(studentComparator);

        StudentInfoTool.writeToFile(students);
    }
}
