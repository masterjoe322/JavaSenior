package cn.sdnu.generic.test.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
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

        Comparator<Employee> com = new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                Employee e1 = (Employee) o1;
                Employee e2 = (Employee) o2;
                if (e1.getBirthday().getYear() != e2.getBirthday().getYear()) {
                    return Integer.compare(e1.getBirthday().getYear(), e2.getBirthday().getYear());
                } else if (e1.getBirthday().getMonth() != e2.getBirthday().getMonth()) {
                    return Integer.compare(e1.getBirthday().getDay(), e2.getBirthday().getDay());
                } else {
                    return Integer.compare(e1.getBirthday().getDay(), e2.getBirthday().getDay());
                }

            }
        };

        Set<Employee> treeSet = new TreeSet<Employee>(com);

        treeSet.add(new Employee("Tom", 78, new MyDate("1999", "03", "22")));
        treeSet.add(new Employee("Jerry", 41, new MyDate("1998", "08", "14")));
        treeSet.add(new Employee("Mike", 14, new MyDate("1992", "04", "22")));
        treeSet.add(new Employee("Sars", 17, new MyDate("2003", "01", "11")));
        treeSet.add(new Employee("Mary", 92, new MyDate("1994", "03", "22")));

        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            System.out.println(next);
        }

    }
}
