package cn.sdnu.commonclass.learn;

import org.junit.Test;

import java.util.Date;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:06 PM
 */
public class DateTimeTest {

    @Test
    public void test() {
        long time = System.currentTimeMillis();

        System.out.println(time);
    }

    /*
    Date :
        java.util.Date
            |---java.sql.Date

        1. two constructors :
            - new Date();
            - new Date(long millisecond);

        2. two method
            > toString() : show year, month, day, hour, minute, second
            > long getTime() : get millisecond of current Time

        3. java.sql.Date : match database
            > create a object : new Date(long millisecond);
            > sql.Date ---> util.Date
                Date date = new java.sql.Date(1232131231L);
            > java.util.Date ----> java.sql.Date
                1.
                    Date date = new java.sql.Date(1232131231L);
                    java.sql.Date date1 = (java.sql.Date)date;
                2.
                    Date date = new Date();
                    java.sql.Date date1 = new java.sql.Date(date.getTime());


     */
    @Test
    public void test2() {
        // constructor 1 new Date(); current time Date object
        Date date = new Date();
        System.out.println(date); // Mon Jan 13 14:10:23 CST 2020
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
        /*
                Mon Jan 13 14:12:35 CST 2020
                1578895955214
                1578895955227
         */

        // constructor 2 : specified millisecond of one time.
        Date date1 = new Date(1508895955227L); // Wed Oct 25 09:45:55 CST 2017
        System.out.println(date1);
    }


    @Test
    public void test3() {
        java.sql.Date date = new java.sql.Date(1234314321312L);
        System.out.println(date); // 2009-02-11
    }

    @Test
    public void test4() {
        Date date = new Date();
        System.out.println(date);

        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
    }

}
