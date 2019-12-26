package cn.sdnu.test;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:17 PM
 */
public class Test1 {

    @Test
    public void testDatabase() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "root1324012");
        System.out.println("connection = " + connection);
    }

    @Test
    public void testConnection()throws  Exception {
        Connection connection = JDBCUtil.getConnection();
        System.out.println("connection = " + connection);
    }

    @Test
    public void testSave() {

    }

    @Test
    public void testBitOperation() throws Exception {
        int i = 1;
        i = i << 31;
        System.out.println("i = " + i);

        System.out.println("Integer.toBinaryString(i + 1) = " + Integer.toBinaryString(i + 1));
    }

    @Test
    public void testBit2() {
        int i = (1 << 31 )+ (1 << 12) - 1;
        System.out.println("i = " + i);
        System.out.println("Integer.toBinaryString(i) = " + Integer.toBinaryString(i));

        i +=(1 << 25);
        System.out.println("i = " + i);
        System.out.println("Integer.toBinaryString(i) = " + Integer.toBinaryString(i));

    }
}
