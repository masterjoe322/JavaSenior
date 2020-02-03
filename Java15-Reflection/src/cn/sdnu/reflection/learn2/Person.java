package cn.sdnu.reflection.learn2;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 12:52 PM
 */
@MyAnnotation("Hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {

    private String name;

    int age;

    public int id;

    public Person() {
    }

    @MyAnnotation("abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("My nation is " + nation);
        return nation;
    }

    public String display(String interests, int age) throws NullPointerException, ClassCastException {
        return interests + age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("I am a person");
    }

    private static void showDetails() {
        System.out.println("I am a cute");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

