package cn.sdnu.collection.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 10:26 AM
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new Person("Jerry", 12));
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(213);

        Iterator iterator = coll.iterator();
        // method 1 : no use
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//
//        // java.util.NoSuchElementException
//        System.out.println(iterator.next());

//        // method 2 : no use
//        for (int i = 0 ; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        // method 3 : suggestion
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 12));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        // fault 1 :
//        while ((iterator.next()) != null) {
//            System.out.println(iterator.next());
//        }

//        // fault 2 :
//        while (coll.iterator().hasNext()) {
//            System.out.println(coll.iterator().next());
//        }
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 12));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            if ("Tom".equals(next)){
                iterator.remove(); // remove one after next the pointer point to the element which there is.
            }
        }

        System.out.println(coll);

//        for (Object o : coll) {
//            System.out.println(o);
//        }

    }


}
