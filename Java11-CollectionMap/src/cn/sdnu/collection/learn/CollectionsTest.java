package cn.sdnu.collection.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 12:30 PM
 */
public class CollectionsTest {
    /*
    Collection Option: Collection & Map


    What is the difference between Collection & Collections ?

     */
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("AA");
        list.add(new Person("Tom", 20));
        list.add(456);
        System.out.println(list);
//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        });
//        Collections.swap(list, 1, 3);

        int frequency = Collections.frequency(list, 123);
        System.out.println("frequency = " + frequency);
        System.out.println(list);
    }


    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("AA");
        list.add(new Person("Tom", 20));
        list.add(456);

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);
        System.out.println("list = " + list);
        System.out.println("dest = " + dest);
    }

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("AA");
        list.add(new Person("Tom", 20));
        list.add(456);
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }
    
}
