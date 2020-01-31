package cn.sdnu.stream.learn;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 9:45 AM
 */
public class InputStreamReaderTest {

    @Test
    public void test1() {
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("Java.txt");

            isr = new InputStreamReader(fis); // using the system default encoding. local host is UTF-8
//            isr = new InputStreamReader(fis, "UTF-8");
//            isr = new InputStreamReader(fis, "GBK"); // Error codes occurs

            char[] chars = new char[20];
            int len;
            while ((len = isr.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        /*
        Comprehensive use InputStreamReader & OutputStreamWriter
         */
        // UTF-8 --> GBK
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream("Java.txt");
            isr = new InputStreamReader(fis);

            FileOutputStream fos = new FileOutputStream("C:\\Users\\Master_Joe\\Desktop\\Hello.txt");
            osw = new OutputStreamWriter(fos, "GBK");

            char[] chars = new char[20];
            int len;
            while ((len = isr.read(chars)) != -1) {
                osw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
