package cn.sdnu.generic.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:29 PM
 */
public class GenericTest {
    /*
    Using Generic :
        1. since 1.5
        2. In Collection :
            - Collection interface or class change to structure with generic since JDK 1.5
            - When defines the objects of Collection, we can define its Generic.
            - if we define generic, the method in collection interface will return the type corresponding to the Generic.
            - Generic must be class type, cannot be fundamental data type, if we want, we can use Integer to packing class.
            - If we did not define the Generic, default type is Object.
        3. Customized Generic Structure : Class, Interface, Method....

     */

    @Test
    public void test1() {
        // No Generic
        ArrayList list = new ArrayList();
        // Requirement: store grade of students
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(99);
        // question1 : type unsafe
        list.add("Tom");

        for (Object score : list) {
            // question2 : Cast might encounter java.lang.ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }


    @Test
    public void test2() {
        // Use Generic
        // And Generic cannot be fundamental data type: for example, int, double, etc.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(99);
        // Type checking makes safe
        // list.add("Tom");
        for (Integer score : list) {
            // avoid type casting
            int stuScore = score;
            System.out.println(stuScore);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {

            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    @Test
    public void test3() {
        // HashMap as an example
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("AA", 123);
        map.put("BB", 456);
        map.put("CC", 789);
        map.put("DD", 12321);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + "---" + value);

        }
    }
}
