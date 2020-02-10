package cn.sdnu.jdk8.stream;

import cn.sdnu.jdk8.practic2.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:56 AM
 */
public class StreamTest1 {
    /*
    Stream options
     */
    @Test
    public void test1() {
        // filter :
        Stream<Employee> stream = EmployeeData.getEmployees().stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();

        Stream<Employee> stream1 = EmployeeData.getEmployees().stream();
        stream1.limit(3).forEach(System.out::println);
        System.out.println();

        Stream<Employee> stream2 = EmployeeData.getEmployees().stream();
        stream2.skip(3).forEach(System.out::println);
        System.out.println();

        List<Employee> list = EmployeeData.getEmployees();
        list.add(new Employee(1010, "Qiang", 40, 8080));
        list.add(new Employee(1010, "Qiang", 40, 8080));
        list.add(new Employee(1010, "Qiang", 40, 8080));
        list.add(new Employee(1010, "Qiang", 40, 8080));
        list.add(new Employee(1010, "Qiang", 40, 8080));
        list.add(new Employee(1010, "Qiang", 40, 8080));
        System.out.println(list);
        System.out.println();

        list.stream().distinct().forEach(System.out::println);


    }

    @Test
    public void test2() {
        // map
        List<String> list = Arrays.asList("AA", "BB", "CC", "DD");
        // String s1.toUpperCase();
        // R apply(T t);
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println();
        // String e.getName()
        // R apply(T)
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee::getName).filter(e -> e.length() > 3).forEach(System.out::println);

        Stream<Stream<Character>> streamStream = list.stream().map(this::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));
        System.out.println();

        Stream<Character> characterStream = list.stream().flatMap(this::fromStringToStream);
        characterStream.forEach(System.out::println);


    }

    /*
    Make the characters in string to a Stream<Character>
     */
    public Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2);
        list1.addAll(list2);

        list1.forEach(System.out::println);
    }

    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(12, 43, 23, 324, 453, 434, 43, 78, 32, 52, 43);
        list.stream().sorted().forEach(System.out::println);
        System.out.println();

//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);


    }


}
