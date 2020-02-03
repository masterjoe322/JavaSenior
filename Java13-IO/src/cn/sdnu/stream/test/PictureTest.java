package cn.sdnu.stream.test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:54 PM
 */
public class PictureTest {

    /*
    Encode Picture
     */
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("bg.jpg");
            fos = new FileOutputStream("bgsecret.jpg");

            byte[] bytes = new byte[20];
            int len;

            while ((len = fis.read(bytes)) != -1) {
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (5 ^ bytes[i]);
                }
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    Decode Picture
     */
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("bgsecret.jpg");
            fos = new FileOutputStream("bg5.jpg");

            byte[] bytes = new byte[20];
            int len;

            while ((len = fis.read(bytes)) != -1) {
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (5 ^ bytes[i]);
                }
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
