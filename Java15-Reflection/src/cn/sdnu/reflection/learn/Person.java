package cn.sdnu.reflection.learn;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:53 PM
 */
public class Person {

    private String name;

    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("Person()");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public void show() {
        System.out.println("I am a Person");
    }

    private String showNation(String nation) {
        System.out.println("My nation is " + nation);
        return nation;
    }
}
