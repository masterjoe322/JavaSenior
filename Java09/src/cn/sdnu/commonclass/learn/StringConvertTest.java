package cn.sdnu.commonclass.learn;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Convert String to Other Types
 *
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:02 PM
 */
public class StringConvertTest {

    @Test
    public void test1() {
        String str1 = "123";
        // int num = (int) str1; // fatal fault
        int num = Integer.parseInt(str1);

        System.out.println(num + 1);

        String str2 = num + "";
        String str3 = String.valueOf(num);

        System.out.println(str2 + ", " + str3);
    }

    @Test
    public void test2() {
        String str = "hello world";

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        /*
            h
            e
            l
            l
            o

            w
            o
            r
            l
            d
         */
    }

    @Test
    public void test3() {
        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o' };
        String str = new String(arr);
        System.out.println(str); // hello

        System.out.println(arr.toString()); // cannot recognize [hello world]
    }

    @Test
    public void test4() throws UnsupportedEncodingException {

        // to byte[]
        String str1 = "abc123我是中国人";
        byte[] bytes = str1.getBytes();
        /*
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        */
        System.out.println(Arrays.toString(bytes)); // default "UTF-8" in my computer, Every Chinese character takes three bytes in UTF-8 Encoding
        // [97, 98, 99, 49, 50, 51, -26, -120, -111, -26, -104, -81, -28, -72, -83, -27, -101, -67, -28, -70, -70]
        byte[] gbks = str1.getBytes("GBK");
        System.out.println(Arrays.toString(gbks)); // GBK, Every Chinese character takes two bytes in GBK Encoding
        // [97, 98, 99, 49, 50, 51, -50, -46, -54, -57, -42, -48, -71, -6, -56, -53]

        String s1 = new String(bytes);
        System.out.println(s1); // abc123我是中国人

        String s2 = new String(gbks);
        System.out.println(s2); // abc123�����й���,  decode with "UTF-8" default in my computer, but encode with "GBK", so the messy code occurred

        String s3 = new String(gbks, "GBK");
        System.out.println(s3); // abc123 我是中国人

    }

    @Test
    public void test5() {
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3); // false

        final String s4 = "javaEE";
        System.out.println(s2 == s4);

        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5); // true, if final String s2 = "hello", s2 is in constant pool.
    }

    @Test
    public void test6() {

    }

}
