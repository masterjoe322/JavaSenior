package cn.sdnu.generic.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:17 PM
 */
public class Order<T> {
    String orderName;
    int orderId;

    // We can use T (generic)
    T orderT;

    public Order() {
        // this style is wrong
//        T[] arr = new T[10];
        // when assignment, we should use generic
        T[] arr = (T[]) new Object[10];
    }


    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    // this is not generic method.
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // Generic cannot be in static method.
//    public static void show(T orderT) {
//        System.out.println(orderT);
//    }

    public void show() {
        // this style is wrong
//        try {
//
//        } catch (T t) {
//
//        }

    }

    // Generic method:
    // 1. generic occurs in method, but this generic is not related to the generic the class has used
    // 2. in other word, the generic in method is not sure in one class with generic
    // 3. Generic method can be static, because the generic has no relationship with Generic Class.

    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> es = new ArrayList<>(Arrays.asList(arr));
        return es;
    }
}


