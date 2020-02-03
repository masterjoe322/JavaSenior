package cn.sdnu.net.learn;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 9:21 PM
 */
public class URLTest {

    @Test
    public void test1() {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/examples/Hello1.jpg");
            System.out.println("url.getProtocol() = " + url.getProtocol());
            System.out.println("url.getHost() = " + url.getHost());
            System.out.println("url.getPort() = " + url.getPort());
            System.out.println("url.getPath() = " + url.getPath());
            System.out.println("url.getFile() = " + url.getFile());
            System.out.println("url.getQuery() = " + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {

        InputStream is = null;
        FileOutputStream fos = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://localhost:8080/examples/Hello1.jpg");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            is = urlConnection.getInputStream();
            fos = new FileOutputStream("bgg.jpg");
            int len;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
