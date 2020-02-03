package cn.sdnu.list.learn;

import cn.sdnu.collection.learn.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 11:20 AM
 */
public class ListTest {


    /*
    List :
        elements in list are sortable and repeatable.

     |----Collection: single row data, like array.
                |----List(interface) : sorted, and repeatable
                    |----ArrayList:
                    |----LinkedList:
                    |----Vector, etc.
    ArrayList, LinkedList, Vector 的异同:
        同:

     */

        /*
        void add(int index, Object ele):
        boolean addAll(int index, Collection eles):
        Object get(int index):
        int indexOf(Object obj):
        int lastIndexOf(Object obj):
        Object remove(int index):
        Object set(int index, Object ele):
        List subList(int fromIndex, int toIndex):
         */
    @Test
    public void test1() {

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 20));
        list.add(456);

        System.out.println(list);

        // void add(int index, Object ele):
        list.add(1, "BB");
        System.out.println(list);

        // addAll(int index, Collection else)
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());

        // Object get(int index)
        System.out.println(list.get(0));

    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 20));
        list.add(456);

        int i = list.indexOf(456); // return the first index in this list, if there is no such element, return -1
        System.out.println(i);

        // int lastIndexOf(Object obj) : return last index.
        int i1 = list.lastIndexOf(456);
        System.out.println(i1);

        // Object remove(int index)
        Object remove = list.remove(0);
        System.out.println(remove);
        System.out.println(list);

        list.set(1, "CC");

        System.out.println(list);

        // List subList(int fromIndex, int toIndex) : fromIndex inclusive, toIndex exclusive;
        List list1 = list.subList(2, 4);
        System.out.println(list);
        System.out.println(list1);

        /*
        Summary :
            Common method:
            1. void add(Object obj)
            2. remove(int index) --- remove(Object obj)
            3. set(int index, Object ele)
            4. get(int index)
            5. add(int index, Object ele)
            6. size()
            7. traverse:
                - Iterator
                - foreach
                - for(int i = 0; i < list.size(); i++) {}
         */

    }

    @Test
    public void test3() {
        // traverse
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 20));
        list.add(456);

        // method1 : use Iterator
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        // method2 : foreach
        for(Object obj : list) {
            System.out.print(obj + ", ");
        }
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
