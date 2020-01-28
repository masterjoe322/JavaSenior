package cn.sdnu.list.test;

import cn.sdnu.collection.learn.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:15 PM
 */
public class Demo3 {
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(3));
        list.add(new Integer(4));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);

        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    private static List duplicateList(List list) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(list);
        return new ArrayList(hashSet);
    }

    @Test
    public void test2() {

        HashSet set = new HashSet();
        Person p1 = new Person("AA", 1001);
        Person p2 = new Person("BB", 1002);

        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        set.remove(p1);
        System.out.println(set); // [Person{name='CC', age=1001}, Person{name='BB', age=1002}]

        set.add(new Person("CC", 1001));
        System.out.println(set); // [Person{name='CC', age=1001}, Person{name='CC', age=1001}, Person{name='BB', age=1002}]


        set.add(new Person("AA", 1001));
        System.out.println(set); // [Person{name='CC', age=1001}, Person{name='CC', age=1001}, Person{name='AA', age=1001}, Person{name='BB', age=1002}]
    }
}
