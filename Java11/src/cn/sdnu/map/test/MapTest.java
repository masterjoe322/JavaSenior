package cn.sdnu.map.test;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 8:34 PM
 */
public class MapTest {

    /*
    |----Map :
        |----HashMap : Common used
            |----LinkedHashMap
        |----TreeMap:
        |----Hashtable:
            |----Properties:
     */

    /*
    Common method in interface Map:
        - Object put(Object key, Object value):
        - void putAll(Map m);
        - Object remove(Object key);
        - void clear();
        - Object get(Object key);
        - boolean containsKey(Object key);
        - boolean containsValue(Object value);
        - int size();
        - boolean isEmpty();
        - boolean equals(Object obj);
        - Set keySet();
        - Collection values();
        - Set entrySet();
     */

    @Test
    public void testMethod1() {
        Map map = new HashMap();

        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);

        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 12);
        map.put("AA", 89);
        System.out.println(map);
        map.putAll(map1);
        System.out.println(map);

        Object value = map.remove("CCC");
        System.out.println(value);
        System.out.println(map);

        map.clear(); // different from "map = null"
        System.out.println(map.size());
        System.out.println(map);
    }

    @Test
    public void testMethod2() {

        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 12);
        map.put("AA", 89);
        // Object get(Object key)
        System.out.println(map.get(45));

        // containsKey();
        System.out.println(map.containsKey("BB"));

        // containsValue();
        System.out.println(map.containsValue(123));

        // size()
        // isEmpty();
        System.out.println(map.isEmpty());
        map.clear();
        System.out.println(map.isEmpty());
    }

    @Test
    public void testMethod3() {
        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put(45, 1234);
        map.put("BB", 12);
        map.put("AA", 89);

        // key traverse
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // value traverse
        Collection values = map.values();
        for (Object object : values) {
            System.out.println(object);
        }

        // key-value traverse
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            // entry all in entrySet
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());

        }

        Set set2 = map.keySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "****" + value);
        }

    }

    @Test
    public void test1() {
        Map map = new HashMap();
        map = new Hashtable();

        map.put(null, null);
    }

    @Test
    public void test2() {
        Map map = new HashMap();
        map = new LinkedHashMap();

        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");

        System.out.println(map);
    }
}
