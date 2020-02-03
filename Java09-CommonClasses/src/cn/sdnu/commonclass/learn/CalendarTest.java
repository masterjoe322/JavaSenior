package cn.sdnu.commonclass.learn;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:17 PM
 */
public class CalendarTest {

    @Test
    public void test1() {
        // 1. new instance
        // 1.1 : create instance of its child class (GregorianCalendar) 'cause it is an abstract class
        Calendar calendar0 = new GregorianCalendar();

        // 1.2 : invoke the static method (Calendar.getInstance());
        Calendar calendar1 = Calendar.getInstance();
//        System.out.println(calendar1.getClass()); // class java.util.GregorianCalendar

        // common method
        // 1.int get(int field)
        int days = calendar0.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 15
        int dayOfWeek = calendar0.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek); // 4
        int dayOfYear = calendar0.get(Calendar.DAY_OF_YEAR);
        System.out.println(dayOfYear); // 15

        // 2.void set(int field, int value); // Variable
        calendar0.set(Calendar.DAY_OF_MONTH, 12);
        System.out.println(calendar0.get(Calendar.DAY_OF_MONTH)); // 12

        // 3.void add(int field, int amount);
        calendar0.add(Calendar.DAY_OF_MONTH, 12);
        System.out.println(calendar0.get(Calendar.DAY_OF_MONTH)); // 24

        // 4.Date getTime(); Calendar ---> Date
        Date time = calendar0.getTime();
        System.out.println(time); // Fri Jan 24 15:38:19 CST 2020

        // 5.void setTime(Date date); Date ----> Calendar
        calendar0.setTime(new Date());




    }


}
