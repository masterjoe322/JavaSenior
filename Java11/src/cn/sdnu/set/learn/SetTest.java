package cn.sdnu.set.learn;

import cn.sdnu.collection.learn.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:47 PM
 */
public class SetTest {

    /*
        |----Collection: single row data, like array.
            |----Set(interface) : unsorted, unrepeatable, like collection in mathematics, unsorted, determinacy, unrepeatable
                |----HashSet : Main implement class, unsafe thread
                |----LinkedHashSet,
                |----TreeSet, etc.
     */

    /*

    - Set :
        1. unsorted: unequal to random. internal storage array does not store according to index of array, but according to hashCode.

        2. unrepeatable: element add into use equals(), must not return true; same element cannot be in the same set.

    - Process of Adding element:
        1. set HashSet as an example:
            - add element "a", first call "a".hashCode() to get hash code value,
                this value to get the index in the array which in internal storage.
                decide if here is not this element "a", if there is other elements,
                e.g. "b", or more than one element as linked table,
                then compare them, until hash & equals return true; or, add "a" into this set
        2. if we add element to set , we must override methods equals() and hashCode();


     */
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(new User("Tom", 20));
        set.add(new User("Tom", 20));
        set.add(129);

        // traverse()
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2() {
        /*
        LinkedHashSet: while storing one element, except element itself, but two pointer, point to previous & next element.

            Advantage: for often traverse option, it is efficiency.

         */
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(new User("Tom", 20));
        set.add(new User("Tom", 20));
        set.add(129);

        // traverse()
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
