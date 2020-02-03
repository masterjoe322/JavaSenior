package cn.sdnu.reflection.learn3;

import cn.sdnu.reflection.learn2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:26 PM
 */
public class OtherTest {

    /*
    Get constructor structures
     */

    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        // getConstructors() : Get the public constructor of current class
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();
        // getDeclaredConstructors() : Get all the constructors in the current Class
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : declaredConstructors) {
            System.out.println(c);
        }
    }

    /*
    Get the super class of current class
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);

    }

    /*
    Get the super class with generic of current class
     */
    @Test
    public void test3() {
        Class<Person> clazz = Person.class;
        Type generic = clazz.getGenericSuperclass();
        System.out.println(generic);
    }

    /*
    Get the generic of super class
     */
    @Test
    public void test4() {
        Class<Person> clazz = Person.class;
        Type generic = clazz.getGenericSuperclass();
        System.out.println("generic = " + generic);
        ParameterizedType paramType = (ParameterizedType) generic;
        System.out.println(paramType);
        Type[] arguments = paramType.getActualTypeArguments();
        System.out.println(arguments[0].getTypeName());

    }
    /*
    Get the interface which implemented by current class
     */
    @Test
    public void test5() {
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }


//        System.out.println("************");
//        AnnotatedType[] annotatedInterfaces = clazz.getAnnotatedInterfaces();
//        for (AnnotatedType anno : annotatedInterfaces) {
//            System.out.println(anno);
//        }
//        System.out.println("***************");
//
//        System.out.println(Arrays.toString(clazz.getGenericInterfaces()));
        System.out.println("***********");
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);
        }
    }

    /*
    Get package of current class
     */
    @Test
    public void test6() {
        Class<Person> clazz = Person.class;

        Package aPackage = clazz.getPackage();
        System.out.println(aPackage.getName());

    }

    /*
    Get annotations of current class
     */
    @Test
    public void test7() {
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @Test
    public void test8() {
        System.out.println("Hello world");
    }


}
