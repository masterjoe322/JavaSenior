package cn.sdnu.commonclass.test;

import org.junit.Test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:32 PM
 */
public class StringDemo0 {

    /**
     * Reverse one substring of the string in two specified index
     * method 1: using charArray
     *
     * @param str        the string we will operate
     * @param startIndex startIndex of the operation
     * @param endIndex   endIndex
     * @return a new string after reversing
     */
    public String reverse1(String str, int startIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        if (chars.length == 0) {
            return "";
        }
        for (int x = startIndex, y = endIndex; x < y; x++, y--) {
            char temp = chars[x];
            chars[x] = chars[y];
            chars[y] = temp;
        }
        return new String(chars);
    }


    /**
     * Reverse one substring of the string in two specified index
     * method 2: using String concatenate
     *
     * @param str        the string we will operate
     * @param startIndex startIndex of the operation
     * @param endIndex   endIndex
     * @return a new string after reversing
     */
    public String reverse2(String str, int startIndex, int endIndex) {

        if (str == null) {
            return null;
        }

        // 1. header
        String reverseStr = str.substring(0, startIndex);

        // 2. middle
        for (int i = endIndex; i >= startIndex; i--) {
            reverseStr += str.charAt(i);
        }

        reverseStr += str.substring(endIndex + 1);

        return reverseStr;
    }

    /**
     * Reverse one substring of the string in two specified index
     * method 2: using String concatenate
     *
     * @param str        the string we will operate
     * @param startIndex startIndex of the operation
     * @param endIndex   endIndex
     * @return a new string after reversing
     */
    public String reverse3(String str, int startIndex, int endIndex) {
        if (str == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder(str.length());
        builder.append(str.substring(0, startIndex));
        for (int i = endIndex; i >= startIndex; i--) {
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(endIndex + 1));
        return builder.toString();
    }

    @Test
    public void testReverse1() {
        String str = "abcdefghigk";

        String reverse = reverse1(str, 2, 6);
        System.out.println(reverse);
        String reverse1 = reverse2(str, 2, 6);
        System.out.println(reverse1);
    }

}
