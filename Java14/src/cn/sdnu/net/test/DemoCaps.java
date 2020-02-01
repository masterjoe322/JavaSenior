package cn.sdnu.net.test;

import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:32 PM
 */
public class DemoCaps {


    @Test
    public void testClient() throws IOException {




    }

    @Test
    public void testServer() throws IOException {

        ServerSocket serverSocket = new ServerSocket(18800);
        Socket socket = serverSocket.accept();

    }

}
