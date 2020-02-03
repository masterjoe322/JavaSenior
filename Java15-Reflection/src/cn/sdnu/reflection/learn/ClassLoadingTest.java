package cn.sdnu.reflection.learn;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 8:18 AM
 */
public class ClassLoadingTest {
    public static void main(String[] args) {
        System.out.println(A.m);
    }
}

class A {
    static {
        m = 300;
    }
    static int m = 100;
}
