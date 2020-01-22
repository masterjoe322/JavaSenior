package cn.sdnu.commonclass.learn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparable [interface] & Comparator [interface]
 * <p>
 * 1. Comparable
 *
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:35 PM
 */
public class CompareTest {

    /*
        Comparable
          - Like {@code String}, or Integer kind of wrappers, override method compareTo()
          - the standard for overriding compareTo()
              1. if this is greater than obj, then return an integer greater than 0
              2. if this is less than obj, then return an integer less than 0
              3. if this is equals to obj, then return 0
          - for customized class, we must implement Comparable
     */
    @Test
    public void test1() {
        String[] arr = {"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr);

        for (String str : arr) {
            System.out.println(str);
        }
    }

    @Test
    public void test2() {
        Goods[] arr = {new Goods("Lenovo", 128), new Goods("Dell", 123), new Goods("Mi", 12), new Goods("HUAWEI", 99)};
        Arrays.sort(arr);
        for (Goods good : arr) {
            System.out.println(good);
        }
    }


    /*
        Comparator : no implements java.lang.Comparable
            1. override method int compare(Object o1, Object o2);
                - if o1 is greater than o2, return one integer greater than 0;
                - if o1 is less than o2, return one integer less than 0;
                - if o1 is equals o2, return 0;
     */
    @Test
    public void test3() {
        String[] arr = {"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }

                throw new RuntimeException("Type input Error");
//                return 0;
            }
        });

        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test4() {
        Goods[] arr = {new Goods("Lenovo", 128), new Goods("Dell", 123), new Goods("Mi", 12), new Goods("HUAWEI", 99)};
        Arrays.sort(arr, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {

                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())) {
                        return Integer.compare(g1.getPrice(), g2.getPrice());
                    } else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("Type Input ERROR");
            }
        });
        for (Goods good : arr) {
            System.out.println(good);
            System.out.println("Hello world");
        }
    }

    @Test
    public void test5() {

    }

}

