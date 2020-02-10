package cn.sdnu.jdk8.practic2;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * <p>
 * Created by shkstart.
 */
public class MethodRefTest {

    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1() {

        Consumer<String> son = System.out::println;

        son.accept("Hello world");

    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        String str = "Hello world";
        Employee employee = new Employee(1002, "Tom");

        Supplier<String> sup = employee::getName;
        System.out.println(sup.get());
    }

    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> com1 = Integer::compare;
        int compare = com1.compare(12, 21);
        System.out.println(compare);
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        Function<Double, Long> func1 = Math::round;
        Long apply1 = func1.apply(12.1);
        System.out.println("apply1 = " + apply1);

        Long apply2 = func1.apply(12.8);
        System.out.println("apply2 = " + apply2);

    }

    // 情况三：类 :: 实例方法
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test5() {
		Comparator<String> com1 = String::compareTo;
		int compare = com1.compare("H", "K");
		System.out.println(compare);
	}

    //BiPredicate中的boolean test(T t1, T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6() {
		BiPredicate<Person, Son> bi = Person::myTest;
		Person p = new Person(54476252);
		Son s = new Son();
		boolean test = bi.test(p, s);
		System.out.println(test);
	}

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test7() {
    	Function<Employee, String> fun = Employee::getName;
		Employee emp = new Employee(123, "Tom123");
		String apply = fun.apply(emp);
		System.out.println(apply);
	}

}
