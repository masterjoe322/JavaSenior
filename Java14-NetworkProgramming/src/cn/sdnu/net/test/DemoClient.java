package cn.sdnu.net.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:36 PM
 */
public class DemoClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream clientOs = null;
        InputStream clientIs = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 18800);

//            clientOs = socket.getOutputStream();

            clientIs = socket.getInputStream();
            clientOs = socket.getOutputStream();

            Scanner scanner = new Scanner(System.in);
            String str = "";
            while (true) {
                System.out.print("Client: ");
                str = scanner.nextLine();

                if ("exit".equalsIgnoreCase(str)) {
                    System.out.println("Exit");
                    clientOs.write("Exit".getBytes());
                    socket.shutdownOutput();
                    break;
                }

                clientOs.write(str.getBytes());
//                socket.shutdownOutput();

                int len;
                byte[] bytes = new byte[1024];
                StringBuilder string = new StringBuilder();
                while ((len = clientIs.read(bytes)) != -1) {
                    string.append(new String(bytes, 0, len));
                }
                System.out.println("Server: " + string);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientOs != null) {
                try {
                    clientOs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
