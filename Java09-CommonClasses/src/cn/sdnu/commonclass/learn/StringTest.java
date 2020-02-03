package cn.sdnu.commonclass.learn;

import org.junit.Test;

/**
 * using for String
 *
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 9:38 AM
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2); // true, means that string cannot be changed
    }

    /*
    1. String , using for two quotation operators
    2. final class, cannot be extends

    3. Serializable interface implemented, can be transported by network
    4. Comparable interface implemented, can be comparable greater or less

    5. final char[] value, cannot be changed.  have immutability
    6. assign string using literal, which is unique in the constant pool
        if use statement str += "test", there will generate one string and change the address of the str.
        if use replace(), original string did not be changed, a new string is generated

     */
    @Test
    public void test1() {
        String s1 = "abc"; // literal in the constant pool
        String s2 = "abc";
//        s1 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        String s3 = "abc";
        s3 += "def";

        System.out.println(s3); // abcdef
        System.out.println(s2); // abc

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4); // abc
        System.out.println(s5); // mbc
        System.out.println(s4 == s5); // false


    }


    /***********************************************************
     *          *                                              *
     *          *    Heap                                      *
     *          *                                              *
     *          *                                              *
     * Stack    *                                              *
     *          *                                              *
     *          *                                              *
     *          *                                              *
     *          ************************************************
     *          *                                              *
     *          *  Method area  & string constant              *
     * s2***************                                       *
     *          *      *                                       *
     * s1*************"abc" (unique)                           *
     *          *                                              *
     *          *                                              *
     *          *                                              *
     * *********************************************************/

    @Test
    public void test2() {
        // assignment
        // method 1 , s1 equals s2 equals [hello world] in the constant pool
        String s1 = "hello world";
        String s2 = "hello world";

        // new + constructor, s4 equals s3 equals [hello world] in the heap have different address.
        String s3 = new String("hello world");
        String s4 = new String("hello world");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s3 == s4); // false
        System.out.println(s2 == s4); // false

        // if System.identityHashCode is same, the object is the same object
        System.out.println("System.identityHashCode(s1) = " + System.identityHashCode(s1));
        System.out.println("System.identityHashCode(s2) = " + System.identityHashCode(s2));
        System.out.println("System.identityHashCode(s3) = " + System.identityHashCode(s3));
        System.out.println("System.identityHashCode(s4) = " + System.identityHashCode(s4));
    }

    @Test
    public void test3() {
        Person p1 = new Person("Tom", 12); // using literal
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == p2.name); // true

        System.out.println("System.identityHashCode(p1.name) = " + System.identityHashCode(p1.name));
        System.out.println("System.identityHashCode(p2.name) = " + System.identityHashCode(p2.name));

        /*
            true
            true
            System.identityHashCode(p1.name) = 1190035432
            System.identityHashCode(p2.name) = 1190035432
         */


        /*******************************************/
        Person p3 = new Person(new String("Tom"), 12); // new String() in the heap area
        Person p4 = new Person(new String("Tom"), 12);

        System.out.println(p3.name.equals(p4.name)); // true
        System.out.println(p3.name == p4.name); // false

        System.out.println("System.identityHashCode(p3.name) = " + System.identityHashCode(p3.name));
        System.out.println("System.identityHashCode(p4.name) = " + System.identityHashCode(p4.name));

        /*
            true
            false
            System.identityHashCode(p3.name) = 1963387170
            System.identityHashCode(p4.name) = 1323468230
         */

        /* ************************************* */
        p3.name = "Jerry";
        p4.name = "Jerry";

        System.out.println(p3.name == p4.name); // true
        /*
            Same string in the Heap area has different address
            Same string in the constant pool has same address
         */
    }

    @Test
    public void test4() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2; // if there is a variable, equivalently to new String() in the heap

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s5 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s7); // false

        String s8 = s5.intern();
        System.out.println(s3 == s8); // true, because s8 is in the constant  pool

    }




}
