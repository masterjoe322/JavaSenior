package cn.sdnu.commonclass.learn;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * before jdk1.8
 * 1. System currentTimeMillis();
 * 2. java.util.Date & java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 *
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 12:28 PM
 */
public class DateTime2Test {
    /*
    SimpleDateFormat : format & parse
    1. two options
    1.1 format : Date --->String
    1.2 parse : String -->Date
     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        // new instance : using default constructor
        SimpleDateFormat sdf = new SimpleDateFormat();
        // format : Date --->String
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);


        // Parse : String --> Date
//        String str = "2019-01-15";
        String str = "1/15/20 12:35 PM";
        Date parse = sdf.parse(str);
        System.out.println(parse);

//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa" );
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf2.format(date);
        System.out.println(format1);

        // parse : string must match the pattern in the constructor of SimpleDateFormat, or we will get the ParseException
        Date parse1 = sdf2.parse("2020-01-15 12:49:15");
        System.out.println(parse1);
    }

    /*
    Exercise 1 : String "2020-09-08" transfer to java.sql.Date;
     */
    @Test
    public void testExercise1() throws ParseException {
        String birth = "2012-12-09";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = simpleDateFormat.parse(birth);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        System.out.println(sqlDate);
    }

    /*
    Exercise 2 : three days fishing two days drying net
        from 1990-01-01, XXXX-XX-XX fishing or drying net?

    method 1 : long days = (end.getTime() - from.getTime()) / (24 * 60 * 60 * 1000) + 1
                days % 5 :
                    1, 2, 3 : Fishing
                    0, 4 : Drying

     */
    @Test
    public void testExercise2() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String from = "1990-01-01";
        Date fromDate = simpleDateFormat.parse(from);
        long fromMillis = fromDate.getTime();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter year: ");
        String year = scanner.nextLine();
        System.out.print("Enter month: ");
        String month = scanner.nextLine();
        System.out.print("Enter day: ");
        String day = scanner.nextLine();

        String end = year + "-" + month + "-" + day;

        Date endDate = simpleDateFormat.parse(end);
        long endMillis = endDate.getTime();

        Date middleDate = new Date(endMillis - fromMillis);
        long days = middleDate.getTime() / (24 * 60 * 60 * 1000) + 1;

        System.out.println("days = " + days);

        long l = days % 5;
        if (l > 0 && l < 4) {
            System.out.println("Finishing");
        } else {
            System.out.println("Drying net");
        }
    }


}
