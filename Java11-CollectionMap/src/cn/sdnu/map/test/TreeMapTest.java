package cn.sdnu.map.test;

import cn.sdnu.set.learn.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 11:49 AM
 */
public class TreeMapTest {

    /*
    if we put element in TreeMap, the keys must be the same type
    because it will be sorted by Comparator or Comparable.
     */
    @Test
    public void test1() {

        TreeMap treeMap = new TreeMap();
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 32);
        User u3 = new User("Jack", 16);
        User u4 = new User("Rose", 18);
        User u5 = new User("Robot", 43);
        treeMap.put(u1, 124);
        treeMap.put(u2, 144);
        treeMap.put(u3, 135);
        treeMap.put(u4, 138);
        treeMap.put(u5, 120);

        for (Object key : treeMap.keySet()) {
            System.out.println(key + "---" + treeMap.get(key));
        }
    }

    @Test
    public void test2() {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;

                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException("Type Input Error");
                }
            }
        });
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 32);
        User u3 = new User("Jack", 16);
        User u4 = new User("Rose", 18);
        User u5 = new User("Robot", 43);
        treeMap.put(u1, 124);
        treeMap.put(u2, 144);
        treeMap.put(u3, 135);
        treeMap.put(u4, 138);
        treeMap.put(u5, 120);

        for (Object key : treeMap.keySet()) {
            System.out.println(key + "---" + treeMap.get(key));
        }
    }

}
