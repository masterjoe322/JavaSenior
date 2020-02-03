package cn.sdnu.reflection.learn3;

import cn.sdnu.reflection.learn2.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:15 PM
 */
public class ReflectionTest {

    /*
    Get the specified structure : field, method, constructor
     */
    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        //
        Person person = clazz.newInstance();
        // getField(String name) (not suggestion) Get the specified field : the field must be public
        Field id = clazz.getField("age");

        // set value of current field
        // set(); arg1: which object will be set, args2: what value
        id.set(person, 1001);
        // get value of current field
        // get(): args : get which object
        int idValue = (int) id.get(person);
        System.out.println("idValue = " + idValue);
    }

    /*
    How to operate the private field.
     */
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        // Create a new instance of Current class
        Person person = clazz.newInstance();

        // getDeclaredField(String name) : get the specified field of current class
        Field name = clazz.getDeclaredField("name");

        // Set accessible
        name.setAccessible(true);

        // set & get value
        name.set(person, "Tom");
        String nameValue = (String) name.get(person);
        System.out.println("nameValue = " + nameValue);

    }

    /*
    How to operate the method
     */
    @Test
    public void test3() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();
        /*
             getDeclaredMethod();
             @param1 name the name of the method
             @param2 parameterTypes the parameter array
        */
        Method show = clazz.getDeclaredMethod("show", String.class);

        show.setAccessible(true);

        /*
        invoke
            @param1 : who
            @param2 : the parameter array
         */
        
        String nation = (String) show.invoke(person, "CHINA");
        System.out.println("nation = " + nation);

        System.out.println("*********HOW TO INVOKE STATIC METHOD**************");

        // private static void showDetails()
        Method showDetails = clazz.getDeclaredMethod("showDetails");
        showDetails.setAccessible(true);

        // if the method has no return value, the invoke return null
        // if the method is static method, the invoke object can be null.
        Object invoke = showDetails.invoke(null);
        System.out.println(invoke);
    }


    /*
    How to invoke the specified constructor
     */
    @Test
    public void test4() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Person> clazz = Person.class;
        // private Person(String name)
        /*
        1. get the specified constructor
            getDeclaredConstructor
                @param1 args array in constructor
         */
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        // make it accessible
        constructor.setAccessible(true);
        // Invoke the constructor
        Person tom = constructor.newInstance("Tom");
        System.out.println("tom = " + tom);

    }
}
