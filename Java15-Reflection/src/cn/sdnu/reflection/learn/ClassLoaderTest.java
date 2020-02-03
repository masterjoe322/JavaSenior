package cn.sdnu.reflection.learn;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 8:43 AM
 */
public class ClassLoaderTest {

    @Test
    public void test1() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        // Invoke System class Loader 's getParent() : get Extensional ClassLoader
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        // Extensional ClassLoader cannot getParent();
        // 引导类加载器主要负责加载java的核心类库, 无法加载自定义类.
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    /*
    Properties :
     */

    @Test
    public void test2() throws Exception {
        Properties props = new Properties();
        // Here file is in our module.
        // method1: read conf.properties.
        FileInputStream fis = new FileInputStream("src\\  jdbc1.properties");
        props.load(fis);
        // method2 : read conf.properties.
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
//        props.load(is);
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        System.out.println("user = " + user + ", password = " + password);
    }

}
