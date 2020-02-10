package cn.sdnu.jdk8.quoation;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:08 PM
 */
public class ConstructorQuotationTest {

    @Test
    public void test1() {
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());
        System.out.println("********************************");

        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());
        System.out.println("********************************");

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    @Test
    public void test2() {
        Function<Integer, String[]> func = length -> new String[length];
        String[] apply = func.apply(5);
        System.out.println(apply.length);

        Function<Integer, String[]> func2 = String[] :: new;
        String[] apply1 = func2.apply(10);
        System.out.println(apply1.length);
    }

}
