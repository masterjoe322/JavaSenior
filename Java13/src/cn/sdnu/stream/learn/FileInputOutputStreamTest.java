package cn.sdnu.stream.learn;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:29 PM
 */
public class FileInputOutputStreamTest {

    // if we use InputStream Or OutputStream, the text might occurs garbled / error code.
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            // 1. File
            File file = new File("Hello.txt");

            // 2. Stream
            fis = new FileInputStream(file);

            // 3. read
            byte[] bytes = new byte[10];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                String str = new String(bytes, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                // Close Resource
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyPicture() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1. File
            File src = new File("bg2.jpg");
            File dest = new File("bg.jpg");

            // 2. Stream
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            // copy option
            byte[] bytes = new byte[5];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close resource
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    Copy file to Specified path
     */
    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1. File
            File src = new File(srcPath);
            File dest = new File(destPath);

            // 2. Stream
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            // copy option
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close resource
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\Master_Joe\\Desktop\\Test.avi";
        String destPath = "C:\\Users\\Master_Joe\\Desktop\\02.avi";
//        String srcPath = "Hello.txt";
//        String destPath = "Hello3.txt";
        copyFile(srcPath, destPath );
        long end = System.currentTimeMillis();

        System.out.println("Time = " + (end - start)); // 70
    }

}
