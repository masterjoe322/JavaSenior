package cn.sdnu.stream.learn;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:22 PM
 */
public class FileReaderWiterTest {

    /*

    [Abstract Class]            [Node Stream(File Stream)]      [Buffered Stream]
    InputStream                 FileInputStream                 BufferedInputStream
    OutputStream                FileOutputStream                BufferedOutputStream
    Reader                      FileReader                      BufferedReader
    Writer                      FileWriter                      BufferedWriter

     */
    @Test
    public void test() {
        FileReader fr = null;
        try {
        /*
            Read the content in the file to internal storage.
            if file not exists, it will occurs java.io.FileNotFoundException
         */
            // new Instance

            File file = new File("Hello1.txt"); // related current module.

            // create Reader
            // if file not exists, it will occurs java.io.FileNotFoundException
            fr = new FileReader(file);
            // Reading data
            // read() : The character read, or -1 if the end of the stream has been reached
            // method 1:
//        int read = fr.read();
//        while (read != -1) {
//            System.out.print((char) read);
//            read = fr.read();
//        }
            // method 2: just for syntax in java
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close Stream
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        /*
        From Internal Storage into hard disk;
        if file not exists, it will create a new file
        if file exist, if we create FileWriter instance using FileWriter(File file, false) or FileWriter(file
            it will override the content in the file
            else if use FileWriter(file, true), it will append you have write.
         */
        FileWriter fw = null;
        try {
            // new instance of File
            File file = new File("Hello1.txt");
            // 2. Get object of FileWriter to write something into hard disk
            fw = new FileWriter(file, true);

            // 3. write option
            // if file not exists, it will create a new file
            fw.write("I have a dream!\n");
            fw.write("You need to have a dream, too");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. close stream
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // Overload of read();
    @Test
    public void testRead() {
        FileReader fr = null;
        try {
            // 1. new instance of File
            File file = new File("Hello.txt");
            // 2. FileReader ... Stream get an instance
            fr = new FileReader(file);

            // 3. Option : Reading
            char[] cbuf = new char[5];
            int len;
            // return the number of characters into char[], return -1 if the end of the stream has been reached;
            while ((len = fr.read(cbuf)) != -1) {
                // wrong way1:
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.println(cbuf[i]);
//                }
                // right way:
//                for (int i = 0; i < len; i++) {
//                    System.out.println(cbuf[i]);
//                }
                // wrong way2:
//                String str = new String(cbuf);
//                System.out.println(str);

                // right way2 :
                String str = new String(cbuf, 0, len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. Close Resource
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test3() {
        // 1. create instance of File & FileWriter & FileReader
        File file = new File("bg2.jpg");
        File file1 = new File("bg1.jpg");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(file);
            fw = new FileWriter(file1);
            // 2. Read & Writer Option
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len); // every time write length is len;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. close Resource
            // method1 :
//            try {
//                if (fw != null) {
//                    fw.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (fr != null) {
//                    fr.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            // method 2:
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fr != null) {
                        fr.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }

    @Test
    public void testInputStream() {
        File file1 = new File("bg2.jpg");
        File file2 = new File("bg1.jpg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFinally() {
        int a = 0;
        try {
            System.out.println(12 / a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println(1 / 0);
            } catch (Exception e) {
                e.printStackTrace();
                a = a + 1;
            }
            System.out.println(a);

        }
    }


    public static void main(String[] args) {
        File file = new File("Hello.txt");
        System.out.println(file.getAbsolutePath());

        File file1 = new File("Java13\\Hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

}
