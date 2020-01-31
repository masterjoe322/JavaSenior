package cn.sdnu.otherstream.learn;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 6:37 PM
 */
public class RandomAccessFileTest {

    /*
    Using RandomAccessFile
        - extends java.lang.Object
        - implements DataInput & DataOutput.
        - it can be an input stream and an output stream
        - if RandomAccessFile as output stream, if file not exists, create file and write content.
            if file exits, override content, from the first letter, only override the length we write, other will not be modified.
     */

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("bg.jpg"), "r");
            raf2 = new RandomAccessFile(new File("bg3.jpg"), "rw");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = raf1.read(bytes)) != -1) {
                raf2.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {

                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("Hello.txt", "rw");

            raf.write("Xyz".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("Hello.txt", "rw");
            raf.seek(3); // set pointer to index 3
            raf.write("xyz".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4() {
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            raf = new RandomAccessFile(new File("Hello.txt"), "r");
            raf1 = new RandomAccessFile(new File("Hello.txt"), "rw");

            raf.seek(3);
            byte[] bytes = new byte[1024];
            StringBuilder str = new StringBuilder((int) (new File("Hello.txt").length()));
            int len;
            while ((len = raf.read(bytes)) != -1) {
                str.append(new String(bytes, 0, len));
            }
            raf1.seek(3);
            raf1.write("xyz".getBytes());
            raf1.write(str.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test5() {

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("He.txt"), "rw");
            raf.seek(3);
            StringBuilder str = new StringBuilder((int) (new File("He.txt").length()));
            int len;
            byte[] bytes = new byte[1024];

            while ((len = raf.read(bytes)) != -1) {
                str.append(new String(bytes, 0, len));
            }

            raf.seek(3);
            raf.write("@@@@@".getBytes());
            raf.write(str.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }















}
