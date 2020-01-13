package cn.sdnu.commonclass.test;

import org.junit.Test;

import static com.sun.jmx.snmp.ThreadContext.contains;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:53 PM
 */
public class StringDemo1 {


    /**
     * Get the count of {@code subStr} in the {@code mainStr}
     *
     * @param mainStr mainStr
     * @param subStr  subStr
     * @return the count of subStr in the mainStr
     */
    public int getCount1(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();

        int count = 0;
        if (mainLength >= subLength) {
//            for (int i = 0; i < mainLength;) {
            while (mainStr.contains(subStr)) {
                count++;
//                    mainStr = mainStr.substring(mainStr.substring(mainStr.indexOf(subStr) + 1).indexOf(subStr));
                mainStr = mainStr.substring(mainStr.indexOf(subStr) + subLength);
            }
        }

        /*
        while (true) {
            if (mainStr.contains(subStr)) {
                count++;
//              mainStr = mainStr.substring(mainStr.substring(mainStr.indexOf(subStr) + 1).indexOf(subStr));
                mainStr = mainStr.substring(mainStr.indexOf(subStr) + subLength);
            } else {
                break;
            }
        }
         */

        return count;
    }

    /**
     * Get the count of {@code subStr} in the {@code mainStr}
     *
     * @param mainStr mainStr
     * @param subStr  subStr
     * @return the count of subStr in the mainStr
     */
    public int getCount2(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();

        int count = 0;
        int index = 0;
        if (mainLength > subLength) {

            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLength;
            }

            return count;
        } else {
            return 0;
        }
    }

    @Test
    public void test1() {
        String str1 = "helloworldhelloworldhelloworlddfhfjdafhkhelloworldfdaajfhellodhfajkworld";
        String str2 = "hello";

        int count = getCount2(str1, str2);
        System.out.println(count);
    }

}
