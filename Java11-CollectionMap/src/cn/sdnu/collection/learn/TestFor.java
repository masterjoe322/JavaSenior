package cn.sdnu.collection.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 11:06 AM
 */
public class TestFor {

    /*
    jdk 5.0, add foreach loop
     */
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 12));
        coll.add(new String("Tom"));
        coll.add(false);

        // for (ElementType element : Collection[we need to traverse])
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};

        // for (ElementType element : array [we need to traverse])
        for (int i : arr) {
            System.out.println(i);
        }

        //
    }

    @Test
    public void test3() {
        String[] str = new String[] {"MM", "MM", "MM"};

//        // normal for loop
//        for (int i = 0; i < str.length; i++) {
//            str[i] = "GG";
//        }

//        // foreach
//        for (String s : str) {
//            s = "GG";
//        }

        for (int  i = 0;  i < str.length; i++) {
            System.out.println(str[i]);
        }

    }
}
