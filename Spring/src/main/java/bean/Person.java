package bean;

public class Person {
    private String lastName;
    private Integer age;
    private String email;
    private String gender;

    public Person() {
        System.out.println("无参构造器被调用了...");
    }

    public Person(String lastName, Integer age, String email, String gender) {
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.gender = gender;
        System.out.println("有参构造器被调用...");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        System.out.println(this.lastName+"setName方法被调用了...");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
