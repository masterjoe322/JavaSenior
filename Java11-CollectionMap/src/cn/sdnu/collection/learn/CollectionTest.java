package cn.sdnu.collection.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:20 PM
 */
public class CollectionTest {
    /*
    Collections Framework :
        1. like array, they are both a kind container, which contains more than one object or other instance. Call Java Container.
        2. these container which just can store elements in internal storage. It's none about data persistence.
        3. for array :
            1. Feature
                - initialize with a constant length;
                - initialize with a constant type; e.g. String[] arr = new String[5];
            2. Disadvantage :
                - its length cannot be changed.
                - the elements in array cannot be changed, e.g. insert, remove, update, query, inconvenient.
                - cannot get the number of we have added, except initialized 0 or null, and so on.

     */

    /*
    Collection Framework :
        |----Collection: single row data, like array.
            |----List(interface) : sorted, and repeatable
                |----ArrayList, LinkedList, Vector, etc.
            |----Set(interface) : unsorted, unrepeatable, like collection in mathematics, unsorted, determinacy, unrepeatable
                |----HashSet, LinkedHashSet, TreeSet, etc.
        |----Map : two rows data, key-value, similar to like function in mathematics. y = f(x), x : key, y : value.
            |----HashMap, LinkedHashMap, TreeMap, HashTable, Properties, etc.
     */

    /*
    Collection Interface :
        1. method :
            - boolean add(E e);
            - int size();
            - boolean addAll(Collection<? extends E> c);
            - boolean isEmpty();
            - void clear();
     */
    @Test
    public void test1() {

        Collection coll = new ArrayList();

        // 1. boolean add(E e)
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        // 2. int size()
        System.out.println(coll.size());

        // 3.  boolean addAll(Collection<? extends E> c);
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());
        System.out.println(coll);

        // void clear();
        coll.clear();

        // 4. boolean isEmpty();
        System.out.println(coll.isEmpty());
    }
}
