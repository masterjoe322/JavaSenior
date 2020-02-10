package cn.sdnu.jdk8.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 1:16 PM
 */
public class LambdaTest {

    @Test
    public void test1() {

        Runnable r1 = new Runnable() {

            @Override
            public void run() {
                System.out.println("I love Beijing");
                System.out.println("Hello world");
            }
        };

        r1.run();

        System.out.println("########################");

        Runnable r2 = () -> System.out.println("I love Beijing");
        System.out.println(r2);

    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return Integer.compare(o1, o2);

            }
        };

        int c1 = com1.compare(12, 21);
        System.out.println(c1);
        System.out.println("########################");

        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int c2 = com1.compare(12, 21);
        System.out.println(c2);
        System.out.println("########################");

        Comparator<Integer> com3 = (o1, o2) -> Integer.compare(o1, o2);
        int c3 = com3.compare(12, 21);
        System.out.println(c3);
    }

    @Test
    public void test3() {

    }

}
