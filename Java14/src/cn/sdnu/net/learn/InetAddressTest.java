package cn.sdnu.net.learn;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 10:36 AM
 */
public class InetAddressTest {

    /*

Network : IP & Address

    */
    @Test
    public void test1() {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.1.1");
            System.out.println(inet1);

//            InetAddress inet2 = InetAddress.getByName("google.com");
            InetAddress inet2 = InetAddress.getByName("localhost");
            System.out.println(inet2);

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);

            System.out.println(localHost.getHostName());
            System.out.println(localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            InetAddress byName = InetAddress.getByName("Joe-PC");
            System.out.println(byName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
