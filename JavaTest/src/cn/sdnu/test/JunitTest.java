package cn.sdnu.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 11:43 AM
 */
public class JunitTest {


    private static Object[] array;

    private static int total;

    @BeforeClass
    public static void init() {
        System.out.println("Initialize Array");
        array = new Object[5];
    }

    @Before
    public void before() {
        System.out.println("Before invoking total = " + total);
    }

    @Test
    public void add() {
        System.out.println("Add");
        array[total++] = "Hello";
    }

    @After
    public void after() {
        System.out.println("Before invoking total = " + total);
    }

    @AfterClass
    public static void destroy() {
        array = null;
        System.out.println("destroy array");
    }


}
