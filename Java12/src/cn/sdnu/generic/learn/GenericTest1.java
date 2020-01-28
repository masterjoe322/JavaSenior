package cn.sdnu.generic.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:03 PM
 */
public class GenericTest1 {
    /*
    1. Customized Generic Class
     */

    @Test
    public void test1() {
        // when we newInstance without generic, default Object.
        // NewInstance with Generic is suggested.
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("Tom");


        // Suggestion: newInstance with Generic
        Order<String> order1 = new Order<>("orderAA", 1001, "Order: AA");
        order1.setOrderT("Hello");
        System.out.println(order1);
    }

    @Test
    public void test2() {
        // if the subclass extends specified generic superclass.
        // we did not need to specify the generic
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT("Hello world");
        System.out.println(subOrder);

        SubOrder<String> subOrder1 = new SubOrder<>();
        subOrder1.setOrderT("Hello world");
    }

    @Test
    public void test3() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;

        // different generic cannot be assignment each other.
        // list2 = list1;

        Person p1 = null;
        Person p2 = null;

        p1 = p2;

    }

    @Test
    public void test4() {
        Order<String> order = new Order<>();

        Integer[] arr = new Integer[] {1, 2, 3, 4};

        List<Integer> integers = order.copyFromArrayToList(arr);

        System.out.println(integers);

    }

}
