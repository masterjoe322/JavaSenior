package cn.sdnu.list.test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 6:40 PM
 */
public class Employee implements Comparable {

    private String name;

    private int age;

    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee other = (Employee) o;
            return this.name.compareTo(other.name);
        } else {
            throw new RuntimeException("Type Input Error");
        }
    }
}
