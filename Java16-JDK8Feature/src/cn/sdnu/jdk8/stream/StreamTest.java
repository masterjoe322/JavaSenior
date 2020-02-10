package cn.sdnu.jdk8.stream;

import cn.sdnu.jdk8.practic2.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:35 PM
 */
public class StreamTest {
    /*
    Stream for CPU, Collection for internal storage.
     */

    /*
    Get an instance of Stream API
     */

    /*
    Method1 : according to one existing Collection
     */
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();

        Stream<Employee> parallelStream = list.parallelStream();

    }

    /*
    Method2 : according to one existing array
     */
    @Test
    public void test2() {
//        List<Employee> list = EmployeeData.getEmployees();

        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");

        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> employeeStream = Arrays.stream(arr1);
    }

    /*
    Method 3 : using the method "of" in stream
     */
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    /*
    Method 4 :
     */
    @Test
    public void test4() {
        // traverse the first ten even number
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
