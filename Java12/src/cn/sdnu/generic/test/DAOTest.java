package cn.sdnu.generic.test;

import org.junit.Test;

import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 6:04 PM
 */
public class DAOTest {

    @Test
    public void test1() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());

        List<Customer> forList = customerDAO.getForList();

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.add(new Student());

        Student index = studentDAO.getIndex(1);
    }

}
