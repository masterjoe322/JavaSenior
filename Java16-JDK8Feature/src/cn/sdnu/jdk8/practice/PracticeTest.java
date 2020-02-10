package cn.sdnu.jdk8.practice;

import cn.sdnu.jdk8.quoation.Employee;
import cn.sdnu.jdk8.quoation.EmployeeData;
import org.junit.Test;

import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:49 PM
 */
public class PracticeTest {

    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        employees.sort((o1, o2) -> {
            if (o1.getAge() != o2.getAge()) {
                return Integer.compare(o1.getAge(), o2.getAge());
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

}
