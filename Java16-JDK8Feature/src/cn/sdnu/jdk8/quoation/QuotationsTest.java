package cn.sdnu.jdk8.quoation;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:47 PM
 */
public class QuotationsTest {
    @Test
    public void test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("Beijing");
        System.out.println("*******************************");

        Consumer<String> con2 = System.out::println;
        con2.accept("Hello world");
    }

    @Test
    public void test2() {
        Employee employee = new Employee(1001, "Tom", 23, 3200.00);
        Supplier<String> sup1 = () -> employee.getName();
        System.out.println(sup1.get());

        Supplier<String> sup2 = employee::getName;
        System.out.println(sup2.get());
    }

    @Test
    public void test4() {
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(12, 21));
        System.out.println("**********************************************");

        Comparator<Double> com2 = Double::compare;
        System.out.println(com2.compare(12.0, 21.0));
    }

    @Test
    public void test5() {
        Comparator<String> com1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com1.compare("Hello", "Hell"));
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        Comparator<String> com2 = String::compareTo;
    }

    @Test
    public void test6() {
        Employee employee = new Employee(1001, "Tom", 12, 120000);
        Function<Employee, String> fun = Employee::toString;
        String apply = fun.apply(employee);
        System.out.println(apply);
    }

    @Test
    public void test7() {
        String str = "HELLO WORLD";
        LikeFunction<Object, String> con = Object::toString;
    }

//    @Test
//    public void test2() {
//        Map<String, Integer> map = new HashMap<>();
//
//        String str = "";
//        map.merge(str, 1, Integer::sum);
//    }
}
