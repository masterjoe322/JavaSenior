package cn.sdnu.commonclass.test;

import org.junit.Test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 8:58 PM
 */
public class StringDemo2 {

    /**
     * Get the max length substring in two strings
     *
     * @param str1 the one string
     * @param str2 the other string
     * @return the max same string in str1 and str2
     */
    public String getMaxString(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return null;
        }
        if (str1.equals(str2)) {
            return str1;
        }

        int maxLength = 0;
        String maxString = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = str1.length(); j > i; j--) {
                if (str2.contains(str1.substring(i, j))) {
                    if (maxLength != Math.max(str1.substring(i, j).length(), maxLength)) {
                        maxLength = Math.max(str1.substring(i, j).length(), maxLength);
                        maxString = str1.substring(i, j);
                    }
                }
            }
        }
        return maxString;
    }

    /**
     * Get the max length substring in two strings
     *
     * @param str1 the one string
     * @param str2 the other string
     * @return the max same string in str1 and str2
     */
    public String getMaxString2(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return null;
        }
        if (str1.equals(str2)) {
            return str1;
        }

        String minString = str1.length() > str2.length() ? str2 : str1;
        String maxStr = str1.length() > str2.length() ? str1 : str2;

        int maxLength = 0;
        String maxString = "";
        for (int i = 0; i < minString.length(); i++) {
            for (int j = minString.length(); j > i; j--) {
                if (maxStr.contains(minString.substring(i, j))) {
                    int length = minString.substring(i, j).length();
                    if (maxLength != Math.max(length, maxLength)) {
                        maxLength = Math.max(length, maxLength);
                        maxString = minString.substring(i, j);
                    }
                }
            }
        }
        return maxString;
    }


    @Test
    public void test1() {
        String str1 = "HellodjfkahafdsafdfdasdfadsfadfsasdffjkhdafhWorld";
        String str2 = "fhkjdahsfWasdfasdfasdfasdforldHellohWorldj";

        String maxString = getMaxString(str1, str2);
        String maxString2 = getMaxString2(str1, str2);
        System.out.println("maxString = " + maxString);
        System.out.println("maxString2 = " + maxString2);

    }

}
