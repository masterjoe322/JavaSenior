package cn.sdnu.stream.learn;

import org.junit.Test;

import java.io.*;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:00 PM
 */
public class BufferedTest {
    /*
    Copy files
     */
    @Test
    public void test1() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. File
            File src = new File("bg.jpg");
            File dest = new File("bg4.jpg");
            // 2. Stream
            // 2.1
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);

            // 2.2
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buff = new byte[16];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. close resource
            // close order: close out first, close inner after
            try {
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // close out will close inner. we can omit inner close
//        fos.close();
//        fis.close();
        }
    }

    // Copy Files
    public void copyFileWithBuffered(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. File
            File src = new File(srcPath);
            File dest = new File(destPath);
            // 2. Stream
            // 2.1
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);

            // 2.2
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buff = new byte[1024];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. close resource
            // close order: close out first, close inner after
            try {
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // close out will close inner. we can omit inner close
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered() {
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\Master_Joe\\Desktop\\Test.avi";
        String destPath = "C:\\Users\\Master_Joe\\Desktop\\02.avi";
//        String srcPath = "Hello.txt";
//        String destPath = "Hello3.txt";
        copyFileWithBuffered(srcPath, destPath);
        long end = System.currentTimeMillis();

        System.out.println("Time = " + (end - start));
    }

    @Test
    public void testBufferedReader() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("Java.txt")));
            bw = new BufferedWriter(new FileWriter(new File("Java2.txt")));
            // method1 :
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1) {
//                bw.write(cbuf, 0, len);
//            }
            // method 2:
            String line;
            while ((line = br.readLine()) != null) {
                // method 1:
//                bw.write(line + "\n");
                // method 2:
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
