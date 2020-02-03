package cn.sdnu.reflection.learn;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:52 PM
 */
@SuppressWarnings("ALL")
public class ReflectionTest {

    /*
    Before reflection :
     */
    @Test
    public void test1() {
        // Create a new instance of Person
        Person p1 = new Person("Tom", 12);

        // By instance, we call get the field (not private) and method (not private).
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();
        // We cannot invoke the private method or other structure.
        // for example, name, showNation(), etc.
    }

    /*
    After Reflection

     */
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);

        Person tom = cons.newInstance("Tom", 12);
        System.out.println(tom);
        Field age = clazz.getDeclaredField("age");
        age.set(tom, 11);
        System.out.println(tom);
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(tom);
    }

    @Test
    public void test3() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Class<Person> clazz = Person.class;

        // By Reflection, create object of Person.
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());
        // Get the field of Person
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());

        // Invoke Method
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        // According to Reflection, we can invoke the private method an private field ...
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);

        // Invoke private Constructor
        cons1.setAccessible(true);
        Person guangtong = cons1.newInstance("Guangtong");
        System.out.println(guangtong);

        // modify private field
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(guangtong, "HanMeimei");
        System.out.println(guangtong);

        // Invoke private method
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(guangtong, "中国");
        System.out.println(nation);

        /*
        Summary :

         */
    }

    /*
    How to get instance of java.lang.Class
     */
    @Test
    public void test4() throws ClassNotFoundException {
        // method1 : call class field ,.class
        Class<Person> class1 = Person.class;
        System.out.println(class1);
        Person p1 = new Person();
        // method2 : invoke .getClass() method
        Class<? extends Person> class2 = p1.getClass();
        System.out.println(class2);

        // method3 :  invoke static method of Class (forName(String class));
        Class<?> class3 = Class.forName("cn.sdnu.reflection.learn.Person");
//        class3 = Class.forName("java.lang.String");
        System.out.println(class3);
        System.out.println(class1 == class2); // true
        System.out.println(class1 == class3); // true

        // Using classLoader();
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> class4 = classLoader.loadClass("cn.sdnu.reflection.learn.Person");
        System.out.println(class4);
        System.out.println(class1 == class4);

    }

    @Test
    public void test5() {
        Class<Void> void1 = void.class;
        System.out.println(void1);
    }

    @Test
    public void test6() {
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class<? extends int[]> c11 = b.getClass();
        Class<? extends int[]> c10 = a.getClass();

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);
        System.out.println("c5 = " + c5);
        System.out.println("c6 = " + c6);
        System.out.println("c7 = " + c7);
        System.out.println("c8 = " + c8);
        System.out.println("c9 = " + c9);
        System.out.println("c10 = " + c10);
        System.out.println("c11 = " + c11);
        System.out.println("c10 == c11 = " + (c10 == c11)); // true

    }


}
