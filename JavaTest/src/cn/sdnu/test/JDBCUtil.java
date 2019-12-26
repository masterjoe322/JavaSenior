package cn.sdnu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:36 PM
 */
public class JDBCUtil {
    public static final String URL = "jdbc:mysql:///test";
    public static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "test";
    public static final String PASSWORD = "test123";


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(CLASS_NAME);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }



}
