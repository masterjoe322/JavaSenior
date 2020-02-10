package cn.sdnu.jdk8.practice;

import org.junit.Test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 6:46 PM
 */
public class LambdaTest {

    @Test
    public void test1() {
        String str = "Hello world";
        String s = toUpperCase(str, String::toUpperCase);
        System.out.println(s);
    }

    @Test
    public void test2() {
        String str = "五十六个星座, 五十六枝花";
        String sub = getSubString(str, s -> s.substring(2, 4));
        System.out.println(sub);
    }

    @Test
    public void test3() {
        Long l1 = 123123L;
        Long l2 = 3523543L;

        Long longSum = getLongSum(l1, l2, Long::sum);
        System.out.println(longSum);

        Long longMul = getLongMul(l1, l2, (l, d) -> l1 * l2);
        System.out.println("longMul = " + longMul);
    }

    public Long getLongSum(Long l1, Long l2, FunctionLike<Long, Long> fl) {
        return fl.getValue(l1, l2);
    }

    public Long getLongMul(Long l1, Long l2, FunctionLike<Long, Long> fl) {
        return fl.getValue(l1, l2);
    }

    /*
    To upper case
     */
    public String toUpperCase(String str, MyInterface myInter) {
        return myInter.getValue(str);
    }

    /*
    Get substring 2, 4
     */
    public String getSubString(String str, MyInterface myInter) {
        return myInter.getValue(str);
    }

}
