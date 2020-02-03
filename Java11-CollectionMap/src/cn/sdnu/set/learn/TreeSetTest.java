package cn.sdnu.set.learn;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:36 PM
 */
public class TreeSetTest {

    /*
        1. if we add elements to TreeSet, we must add same type elements.
        2. we must implement Comparable, so we can add it into TreeSet instance.
        3. for TreeSet, decide if two objects are same, decided by the result of compareTo()
        4. for Comparator, decided by the result of compare();
     */

    @Test
    public void test1() {
        Set set = new TreeSet();

        // java.lang.ClassCastException:
        // if we add elements to TreeSet, we must add same type elements.

        // we must implement Comparable, so we can add it into TreeSet instance.
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 16));
        set.add(new User("Jim", 72));
        set.add(new User("Mike", 56));
        set.add(new User("Jack", 32));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {
            /**
             * Sort by name from greater to less
             *
             * @param o1 this
             * @param o2 other
             * @return if result greater than 0, this is greater than o <br>
             *      if result less than 0, this is less than o<br />
             *      if result is 0, this is equals to o
             */
            @Override
            public int compare(Object o1, Object o2) {

                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;

                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException("Type Input Error");
                }
            }
        };
        TreeSet set = new TreeSet(com);

        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 16));
        set.add(new User("Jim", 72));
        set.add(new User("Merry", 56));
        set.add(new User("Mike", 56));
        set.add(new User("Jack", 32));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
