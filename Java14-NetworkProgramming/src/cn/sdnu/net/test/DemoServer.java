package cn.sdnu.net.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:36 PM
 */
public class DemoServer {

    public static void main(String[] args)  {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream serverIs = null;
        OutputStream serverOs = null;
        try {
            serverSocket = new ServerSocket(18800);
            socket = serverSocket.accept();

            serverIs = socket.getInputStream();
            serverOs = socket.getOutputStream();

            int len;
            byte[] bytes = new byte[1024];
            StringBuilder str = new StringBuilder();
            while ((len = serverIs.read(bytes)) != -1) {
                str.append(new String(bytes, 0, len));
            }
            String s = str.toString().toUpperCase();
            serverOs.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverOs != null) {
                try {
                    serverOs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverIs != null) {
                try {
                    serverIs.close();
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
