package cn.sdnu.reflection.review;

import cn.sdnu.reflection.learn2.Person;
import org.junit.Test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 6:48 PM
 */
public class ReviewTest {

    @Test
    public void test1() throws ClassNotFoundException {
        // Get instance of java.lang.Class
        // method1 :
        Class<Person> c1 = Person.class;
        System.out.println("c1 = " + c1);
        // method2 :
        Person p1=  new Person();
        Class<? extends Person> c2 = p1.getClass();
        System.out.println("c2 = " + c2);

        // method 3:
        Class<?> c3 = Class.forName("cn.sdnu.reflection.learn2.Person");
        System.out.println("c3 = " + c3);

        // method 4:
        ClassLoader classLoader = ReviewTest.class.getClassLoader();
        Class<?> c4 = classLoader.loadClass("cn.sdnu.reflection.learn2.Person");
        System.out.println("c4 = " + c4);


    }
}
