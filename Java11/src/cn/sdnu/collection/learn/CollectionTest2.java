package cn.sdnu.collection.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:25 PM
 */
public class CollectionTest2 {

    /*
        Collection method:
            1. we need override method equals() in the object we will add into collection.
     */
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new Person("Jerry", 12));
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(456);
        coll.add(213);
        // contains(Object object);

        boolean contains = coll.contains(123);
        System.out.println(contains);

        // contains(Object object): different objects has same values
        System.out.println(coll.contains(new String("Tom"))); // true

        // contains() : will call equals() method in objects.
        // and contains() traverses all the objects in collection until
        // finding the object we find;
        System.out.println(coll.contains(new Person("Jerry", 12)));


        // containsAll();
        Collection coll1 = Arrays.asList(123, 213, 456);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {

        // remove(Object obj)
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(123);
        coll.add(new Person("Jerry", 12));
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(456);
        coll.add(213);

        coll.remove(123); // call contains(), remove can only remove one object
        System.out.println(coll);
        // removeAll(Collection coll1);
        Collection coll1 = Arrays.asList(123, 456, 789);

//        coll.removeAll(coll1); // removeAll() can remove more than one object.
//        System.out.println(coll);
//
//        coll.retainAll(coll1); // Intersection
//        System.out.println(coll);

        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(123);
        coll2.add(new Person("Jerry", 12));
        coll2.add(456);
        coll2.add(new String("Tom"));
        coll2.add(false);
        coll2.add(456);
        coll2.add(213);

        // equals(Object obj) :
        boolean equals = coll.equals(coll2); // including the sort of these objects in collections.
        System.out.println(equals);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(123);
        coll.add(new Person("Jerry", 12));
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(456);
        coll.add(213);

        // hashCode(); return hashCode;
        System.out.println(coll.hashCode());

        // Collection ---> Array
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        // Array ---> Collection : Arrays.asList();
        List<Object> list = Arrays.asList(objects);
        System.out.println(list);


        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints);

        List<Integer> integers = Arrays.asList(new Integer[]{123, 456});
        System.out.println(integers);

        // iterator() : return an instance of interface Iterator, traverse all the object in the collection.


    }

}
