package cn.sdnu.jdk8.lambda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 1:16 PM
 */
public class LambdaTest1 {

    /* 1. No arguments, no return value */
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
        r2.run();
    }

    /* 2. one argument, no return value */
    @Test
    public void test2() {
        Consumer<String> cons = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        cons.accept("Hello world");

        System.out.println("********************");
        Consumer<String> cons1 = (String s) -> System.out.println(s);
        cons1.accept("Hello world 1");
    }

    //
    @Test
    public void test3() {

    }

}
