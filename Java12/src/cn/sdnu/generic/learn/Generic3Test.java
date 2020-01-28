package cn.sdnu.generic.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:44 PM
 */
public class Generic3Test {

    /*
    1. Generic :
        - Extends :
            1. if A is super class of B, G<A> is not super class of G<B>
            2. A is super class of B, A<T> is super class of B<T>
        - Wildcard:
            - ?
            - A is super class of B, G<A> & G<B> has no relationship;
            - G<?> is super class of G<A> & G<B>
            - has limit condition.
                ? extends Person
                ? super Person
     */

    @Test
    public void test1() {
        Object obj = null;

        String str = null;
        obj = str;

        Object[] arr = null;
        String[] arr2 = null;
        arr = arr2;

        List<Object> list = null;
        List<String> list1 = null;

        // List<Object> is null the super class of List<String>
        // list = list1

        Date ate = new Date();
//        str = date;
        show(list);
//        show(list1);

    }

    public void show(List<Object> list) {

    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        LinkedList<String> list1 = new LinkedList<>();
        list = list1;
    }

    @Test
    public void test3() {
        List<String> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;


        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");

        list = list3;

        // for List<?>, we cannot add element to it, except null.
//        list.add("DD");
//        list.add();
        // write : not allowed
        list.add(null);

        // read : allowed
        Object o = list.get(1);
        System.out.println(o);

    }


    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    @Test
    public void test4() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

    }

}
