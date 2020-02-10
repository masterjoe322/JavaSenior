package cn.sdnu.jdk8.practic2;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:16 PM
 */
public class Person {
    int id;
    public Person(int id) {
        this.id = id;
    }

    public boolean myTest(Son s) {
        System.out.println("Hello myTest()");
        return this.id == s.hashCode();
    }

}
