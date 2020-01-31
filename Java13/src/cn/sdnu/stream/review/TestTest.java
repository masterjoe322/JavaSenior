package cn.sdnu.stream.review;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:55 PM
 */
public class TestTest {
    @Test
    public void test1() throws Exception {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("hello.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("Hello1.txt"));

    }
}
