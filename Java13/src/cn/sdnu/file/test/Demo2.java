package cn.sdnu.file.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 12:58 PM
 */
public class Demo2 {

    @Test
    public void test1() throws IOException {

        File file = new File("a.txt");
        File file2 = new File(file.getAbsoluteFile().getParent());
        File file3 = new File(file2, "b.txt");

        if (!file3.exists()) {
            boolean newFile = file3.createNewFile();
            if (newFile) {
                System.out.println("Create Successfully");
            }

        }


    }

}
