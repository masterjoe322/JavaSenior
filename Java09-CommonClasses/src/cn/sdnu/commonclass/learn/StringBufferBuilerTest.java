package cn.sdnu.commonclass.learn;

import org.junit.Test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:06 PM
 */
public class StringBufferBuilerTest {

    /*
    String : Immutability, using char[] value storage

    StringBuffer: Variable; Thread safe , inefficiency, using char[] value storage

    StringBuilder: Variable, jdk 5.0 after, thread unsafe, efficiency, using char[] value storage

    jdk source code:
        String str = new String(); // new char[0];
        Sting str1 = new String("abc"); // new char[]{'a', 'b', 'c'};

        StringBuffer sb1 = new StringBuffer(); // initial capacity is 16 // char[] value = new char[16];
        sb1.append('a'); // value[0] = 'a';
        sb1.append('b'); // value[1] = 'b';

        StringBuffer sb2 = new StringBuffer("abc"); // char[] value = new char["abc".length + 16]; // every time when we new StringBuffer, there will be 16 capacity space.
        value[0] = 'a';
        value[1] = 'b';
        value[2] = 'c';


        - while appending
            1. if the length of the string appended to original StringBuffer, it will update capacity to (2 * capacity  + 2)
            2. I suggest StringBuffer.


     */
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        System.out.println(System.identityHashCode(sb1)); // 1190035432

        sb1.setCharAt(0, 'm');
        System.out.println(System.identityHashCode(sb1)); // 1190035432

        sb1.append("hello");
        System.out.println(System.identityHashCode(sb1)); // 1190035432

        System.out.println(sb1);
        System.out.println(sb1.length()); // 8 = abc + hello.

        StringBuffer stringBuffer = new StringBuffer();

        System.out.println("stringBuffer.length() = " + stringBuffer.length()); // 0

        /*
            public synchronized void length() {
                return count;
            }
         */
    }


    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer("Hello world");
        s1.append("Hello world");
        System.out.println(s1);

//        s1.delete(1, 8);
//        s1.replace(1, 2, "hello");
//        s1.insert(2, "Hello");
        // String substring(int start, int end);
        String substring = s1.substring(1, 4);
        System.out.println(substring.length());
        System.out.println(substring);
        StringBuffer reverse = s1.reverse();
        System.out.println(s1);
        System.out.println(reverse);
        // for + charAt() using to transverse StringBuffer.


    }

    /*
        efficiency : StringBuilder > StringBuffer > String
     */
    @Test
    public void test3() {
        long startTime = 0L;
        long endTime = 0L;
        String string = new String("");
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("The time of StringBuffer is " + (endTime - startTime)); // 2

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("The time of StringBuilder is " + (endTime - startTime)); // 2

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            string = string + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("The time of String itself is " + (endTime - startTime)); // 1356

    }

}
