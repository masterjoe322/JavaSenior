package cn.sdnu.net.learn;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:02 PM
 */
public class TCPTest1 {
    /*

    实现TCP的网络变成
        For example :

     */
    // Client
    @Test
    public void testClient() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 18800);
            os = socket.getOutputStream();
            os.write("Hello, I am client".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Server
    @Test
    public void testServer() {
        ServerSocket serverSocket = null;
        Socket acceptSocket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(18800);

            acceptSocket = serverSocket.accept();

            inputStream = acceptSocket.getInputStream();

//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = inputStream.read(bytes)) != -1) {
//            String str = new String(bytes, 0, len);
//            System.out.print(str);
//        }
//        InputStreamReader isr = new InputStreamReader(inputStream);

//        char[] chars = new char[1024];
//        int len;
//
//        while ((len = isr.read(chars)) != -1) {
//            String str = new String(chars, 0, len);
//            System.out.print(str);
//        }
//        isr.close();

            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[16];

            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }

            String s = baos.toString();
            System.out.println(s);
            System.out.println("Get message from: " + acceptSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (acceptSocket != null) {
                try {
                    acceptSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
