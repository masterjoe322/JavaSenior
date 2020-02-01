package cn.sdnu.net.learn;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 8:02 PM
 */
public class UDPTest {

    @Test
    public void sender() {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String str = "我是UDP方式发送的导弹";
            byte[] bytes = str.getBytes();
            InetAddress localHost = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, localHost, 19900);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }

    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(19900);

            byte[] bytes = new byte[1024];

            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);

            socket.receive(packet);

            System.out.print(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }


}
