package cn.sdnu.commonclass.learn;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:48 PM
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate() {
        // Offset
        Date date1 = new Date(2020 - 1900, 9 - 1, 8); // Fri Oct 08 00:00:00 CST 3920
        // Offset year : 1900 , month : 1
        System.out.println(date1);
    }


    /*
    LocalDate, LocalTime, LocalDateTime

    Instructions:
        1. LocalDateTime is the most commonest class we use
        2. LocalDate, LocalTime, LocalDateTime are similar to String with the immutability.
     */
    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("localDate = " + localDate); // localDate = 2020-01-15
        System.out.println("localTime = " + localTime); // localTime = 16:00:37.683
        System.out.println("localDateTime = " + localDateTime); // localDateTime = 2020-01-15T16:00:37.684

        // of
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 12, 12, 12, 23);
        System.out.println(localDateTime1); // 2020-12-12T12:23a


        // common method
        // 1. getXxx()
        System.out.println(localDateTime.getDayOfWeek()); // WEDNESDAY
        System.out.println(localDateTime.getDayOfMonth()); // 15
        System.out.println(localDateTime.getDayOfYear()); // 15
        System.out.println(localDateTime.getMonthValue()); // 1
        System.out.println(localDateTime.getMinute()); // 5

        // Show immutability
        // withXxx(int field)
        LocalDate localDate1 = localDate.withDayOfMonth(18);
        System.out.println(localDate); // 2020-01-05
        System.out.println(localDate1); // 2020-01-18

        LocalDateTime localDateTime2 = localDateTime.withHour(6);
        System.out.println(localDateTime); // 2020-01-15T16:09:36.518
        System.out.println(localDateTime2); // 2020-01-15T06:09:36.518

        // plusXxx()
        LocalDateTime localDateTime3 = localDateTime.plusHours(12);
        System.out.println(localDateTime); // 2020-01-15T16:12:05.188
        System.out.println(localDateTime3); // 2020-01-16T04:12:05.188

        // minus
        LocalDateTime localDateTime4 = localDateTime.minusDays(7);
        System.out.println(localDateTime); // 2020-01-15T16:13:11.709
        System.out.println(localDateTime4); // 2020-01-08T16:13:11.709
    }

    /**
     * Instant
     */
    @Test
    public void test2() {
        // 1. static method now() to get object
        Instant instant = Instant.now();
        System.out.println(instant); // 2020-01-15T08:21:52.273Z

        // 2. Add the zone offset
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2020-01-15T16:21:52.273+08:00

        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);

    }


    /**
     * method 1 : predefined standard format, e.g. ISO_LOCAL_TIME, ISO_LOCAL_DATE_TIME.
     * <p>
     * method 2 : localized related format : e.g. ofLocalizedDateTime(FormatStyle.LONG);
     * <p>
     * method 3 : customized format : e.g. ofPattern("yyyy-MM-dd hh:mm:ss E");
     */
    @Test
    public void test3() {
        // method 1 :
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        // format : LocalDateTime ----> String
        LocalDateTime now = LocalDateTime.now();
        String format = formatter.format(now);
        System.out.println(now);
        System.out.println(format);

        // Parse : String -- > LocalDate
        TemporalAccessor parse = formatter.parse("2020-01-15T19:02:09.738");
        System.out.println(parse);

        // method 2
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        // FormatStyle.SHORT, FormatStyle.MEDIUM
        String format1 = formatter1.format(now);
        System.out.println(format1);

        // FormatStyle.FULL, FormatStyle.LONG, FormatStyle.SHORT, FormatStyle.MEDIUM, FormatStyle.FULL
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format2 = formatter2.format(LocalDate.now());
        System.out.println(format2);


        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format3 = formatter3.format(LocalDateTime.now());
        System.out.println(format3);

        TemporalAccessor parse1 = formatter3.parse("2018-12-12 12:12:12");
        System.out.println(parse1);

    }
}
