package cn.sdnu.jdk8.stream;

import cn.sdnu.jdk8.practic2.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 8:47 AM
 */
public class StreamTest2 {

    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        // allMatch
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        // anyMatch
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

        boolean lei = employees.stream().noneMatch(e -> e.getName().startsWith("Lei"));
        System.out.println(lei);

        /*Optional<Employee> first = employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).findFirst();
        System.out.println(first);
        */

        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
    }

    @Test
    public void test2() {
        // count
        List<Employee> employees = EmployeeData.getEmployees();
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

//        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
//        System.out.println(max);
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> max = salaryStream.max(Double::compare);
        System.out.println(max);

        Optional<Double> max1 = employees.stream().map(Employee::getSalary).max(Double::compare);
        System.out.println(max1);

        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("min = " + min);

        employees.forEach(System.out::println);
        System.out.println();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> reduce = stream.reduce(Integer::sum);
        System.out.println("reduce = " + reduce);

        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1);
    }

    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1);

        System.out.println();
    }

    @Test
    public void test5() {
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("**********************************************");

        Set<Employee> sets = employees.stream().filter(e -> e.getSalary() < 12345).collect(Collectors.toSet());
        sets.forEach(System.out::println);
    }

    @Test
    public void test6() {
        List<Employee> employees = EmployeeData.getEmployees();
        ArrayList<Employee> collect = employees.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toCollection(ArrayList::new));
        collect.forEach(System.out::println);
    }
}
