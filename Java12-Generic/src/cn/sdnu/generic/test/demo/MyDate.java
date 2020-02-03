package cn.sdnu.generic.test.demo;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 6:38 PM
 */
public class MyDate implements Comparable<MyDate> {

    private int year;

    private int month;

    private int day;

    public MyDate(String year, String month, String day) {
        this.year = Integer.parseInt(year);
        this.month = Integer.parseInt(month);
        this.day = Integer.parseInt(day);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "\"" + year + "-" + month + "-" + day + "\"";
    }

    @Override
    public int compareTo(MyDate o) {
        if (year != o.getYear()) {
            return year - o.year;
        }
        if (month != o.month) {
            return month - o.month;
        }
        return day - o.day;
    }

    // Without Generic
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof MyDate) {
//            MyDate other = (MyDate) o;
//            if (other.getYear() != this.getYear()) {
//                return this.getYear() - other.getYear();
//            }
//            if (other.getMonth() != this.getMonth()) {
//                return this.getMonth() - other.getMonth();
//            }
//            return this.getDay() - other.getDay();
//        } else {
//            throw new RuntimeException("Type Input Error");
//        }
//    }
}
