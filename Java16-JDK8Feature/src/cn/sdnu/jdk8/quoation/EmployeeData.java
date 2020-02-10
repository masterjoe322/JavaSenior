package cn.sdnu.jdk8.quoation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:50 PM
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "HuaTeng Ma", 34, 6000.38));
        list.add(new Employee(1002, "Jack Ma", 12, 9876.12));
        list.add(new Employee(1003, "Qiangdong Liu", 33, 3000.82));
        list.add(new Employee(1004, "Jun Lei", 26, 765737));
        list.add(new Employee(1005, "Yanhong Li", 65, 5555.32));
        list.add(new Employee(1006, "Bill Gates", 42, 9500.43));
        list.add(new Employee(1007, "Zhengfei Ren", 26, 4333.32));
        list.add(new Employee(1008, "Mark Elliot Zuckerberg", 35, 2500.32));
        return list;
    }

}
