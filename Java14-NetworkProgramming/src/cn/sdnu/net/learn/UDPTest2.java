package cn.sdnu.net.learn;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:04 PM
 */
public class UDPTest2 {
    @Test
    public void testSender() {
        try (DatagramSocket socket = new DatagramSocket()) {
            String str = "我是UDP发送的信息";
            byte[] bytes = str.getBytes();
            InetAddress localhost = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, localhost, 19900);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testReceiver() {
        try (DatagramSocket socket = new DatagramSocket(19900)) {
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getData().length));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
