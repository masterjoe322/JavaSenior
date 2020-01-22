package cn.sdnu.commonclass.learn;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * System, Math, BigInteger, BigDecimal
 *
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 9:20 AM
 */
public class OtherTest {

    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("javaVersion = " + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("javaHome = " + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("osName = " + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("osVersion = " + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("userName = " + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("userDir = " + userDir);

    }

    @Test
    public void test2() {

        BigInteger bi1 = new BigInteger("12433241123");
        BigDecimal bd1 = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");

        System.out.println(bi1);

//        System.out.println(bd1.divide(bd2)); // it occurs fault
        System.out.println(bd1.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd1.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));

    }

}
