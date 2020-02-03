package cn.sdnu.commonclass.test;

import org.junit.Test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 9:43 PM
 */
public class StringDemo3 {

    @Test
    public void test1() {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);

        System.out.println(stringBuffer.length()); // 4

        System.out.println(stringBuffer); // null

        StringBuffer stringBuffer1 = new StringBuffer(str); // NullPointerException *
        System.out.println(stringBuffer1); //                                       *
        //                                                                          *
        /*                                                                          *
            public StringBuffer(String str) {                                       *
                super(str.length() + 16); *******************************************
                append(str);
            }
         */
    }


}
