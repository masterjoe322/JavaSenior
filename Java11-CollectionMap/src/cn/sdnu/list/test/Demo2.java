package cn.sdnu.list.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 6:25 PM
 */
public class Demo2 {

    @Test
    public void test1() {

        Random random = new Random();

        HashSet hashSet = new HashSet();
        for (int i = 0; i < 10; i++) {
            hashSet.add(random.nextInt(100) + 100);
        }

        ArrayList arrayList = new ArrayList(hashSet);

        Collections.sort(arrayList);

        System.out.println(arrayList);

        for (Object i : arrayList) {
            System.out.print(" " + i);
        }
    }


    @Test
    public void test2() {

        TreeSet treeSet = new TreeSet();

        treeSet.add(new Employee("Tom", 78, new MyDate("1999", "03", "22")));
        treeSet.add(new Employee("Jerry", 41, new MyDate("1998", "08", "14")));
        treeSet.add(new Employee("Mike", 14, new MyDate("1992", "04", "22")));
        treeSet.add(new Employee("Sars", 17, new MyDate("2003", "01", "11")));
        treeSet.add(new Employee("Mary", 92, new MyDate("1994", "03", "22")));

        for (Object o : treeSet) {
            System.out.println(o);
        }


    }

    @Test
    public void test3() {

        Comparator com = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    if (e1.getBirthday().getYear() != e2.getBirthday().getYear()) {
                        return Integer.compare(e1.getBirthday().getYear(), e2.getBirthday().getYear());
                    } else if (e1.getBirthday().getMonth() != e2.getBirthday().getMonth()) {
                        return Integer.compare(e1.getBirthday().getDay(), e2.getBirthday().getDay());
                    } else {
                        return Integer.compare(e1.getBirthday().getDay(), e2.getBirthday().getDay());
                    }
                } else {
                    throw new RuntimeException("Type Input Error");
                }
            }
        };

        TreeSet treeSet = new TreeSet(com);

        treeSet.add(new Employee("Tom", 78, new MyDate("1999", "03", "22")));
        treeSet.add(new Employee("Jerry", 41, new MyDate("1998", "08", "14")));
        treeSet.add(new Employee("Mike", 14, new MyDate("1992", "04", "22")));
        treeSet.add(new Employee("Sars", 17, new MyDate("2003", "01", "11")));
        treeSet.add(new Employee("Mary", 92, new MyDate("1994", "03", "22")));

        for (Object o : treeSet) {
            System.out.println(o);
        }

    }
}
