package cn.sdnu.properties.learn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 12:02 PM
 */
public class PropertiesTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties props = new Properties();
            fis = new FileInputStream("jdbc.properties");
            props.load(fis);
            String name = props.getProperty("name");
            String password = props.getProperty("password");
            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
