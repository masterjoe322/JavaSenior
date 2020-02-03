package cn.sdnu.commonclass.learn;

import org.junit.Test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:07 PM
 */
public class StringMethodTest {

    @Test
    public void test1() {
        String s1 = "Hello world";

        System.out.println("s1.length() = " + s1.length()); // 11
        System.out.println("s1.charAt(1) = " + s1.charAt(1)); // e
        System.out.println("s1.charAt(10) = " + s1.charAt(10)); // d
        System.out.println("s1.isEmpty() = " + s1.isEmpty());
        System.out.println("s1 = " + s1);
        String lower = s1.toLowerCase(); // heap area
        String hello = "hello world"; // literal
        System.out.println(hello == lower);
        System.out.println("s1.toLowerCase() = " + s1.toLowerCase());
        System.out.println("s1.toUpperCase() = " + s1.toUpperCase());
        System.out.println("s1 = " + s1);

    }

    @Test
    public void test2() {
        String s1 = "      Hel l o w or ld       ";

        System.out.println("s1 = " + s1);
        System.out.println("s1.length() = " + s1.length());
        System.out.println("s1.trim() = " + s1.trim()); // ignore the spaces front and behind
        System.out.println("s1.trim().length() = " + s1.trim().length());
    }

    @Test
    public void test3() {
        String s1 = "hello world";
        String s10 = new String("hello world");
        String s2 = "Hello World";

        System.out.println("s1.equals(s2) = " + s1.equals(s2)); // false
        System.out.println("s1.equals(s10) = " + s1.equals(s10)); // true
        System.out.println("s1.equalsIgnoreCase(s2) = " + s1.equalsIgnoreCase(s2)); // true
    }

    @Test
    public void test4() {
        String s1 = "abc";
        String s2 = s1.concat("def");

        System.out.println("s1 = " + s1); // abc
        System.out.println("s2 = " + s2); // abcdef

    }

    @Test
    public void test5() {
        String s1 = "abc";
        String s2 = "abd";

        System.out.println("s1.compareTo(s2) = " + s1.compareTo(s2)); // -1
        System.out.println("s2.compareTo(s1) = " + s2.compareTo(s1)); // 1

        String s3 = "hello world";

        String s4 = s3.substring(6);
        System.out.println(s4); // world

        String s5 = s3.substring(0, 5); // beginIndex is inclusive, endIndex is exclusive
        System.out.println(s5);

    }

    @Test
    public void test6() {
        String s1 = "Helloworld";

        System.out.println(s1.endsWith("ld")); // true

        System.out.println(s1.startsWith("He")); // true

        System.out.println(s1.startsWith("ll", 2)); // true

    }

    @Test
    public void test7() {
        String str1 = "hello world";
        String str2 = "wor";

        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf("lo")); // 3

        System.out.println(str1.indexOf("lol")); // -1

        System.out.println(str1.indexOf("lo", 5)); // -1

        String str3 = "helloeworld";
        System.out.println(str3.indexOf("or")); // 7
        System.out.println(str3.lastIndexOf("or")); // 7


        System.out.println(str3.lastIndexOf("or", 6)); // -1

    }

    @Test
    public void test8() {
        String str = "helloworld";

        String replace = str.replace('o', 'w');
        System.out.println("str = " + str);
        System.out.println("replace = " + replace); // replace all characters matched
    }

    @Test
    public void test9() {
        // replaceAll(String regex, String replacement);
        // regex: regular expression


    }

    @Test
    public void test10() {
        String str = "hello|world|java";

        String[] split1 = str.split("|");
        System.out.println(split1.length);
        for (int i = 0; i < split1.length; i++) {
            System.out.println("split[i] = " + split1[i]);
        }

        /*
            16
            split[i] = h
            split[i] = e
            split[i] = l
            split[i] = l
            split[i] = o
            split[i] = |
            split[i] = w
            split[i] = o
            split[i] = r
            split[i] = l
            split[i] = d
            split[i] = |
            split[i] = j
            split[i] = a
            split[i] = v
            split[i] = a
         */

        /* ******************** */
        String str1 = "hello,world,java";
        String[] split = str1.split(",");
        System.out.println(split.length);

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        /*
            3
            hello
            world
            java
         */

    }

}
