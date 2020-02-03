package cn.sdnu.file.learn;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 9:28 PM
 */
public class FileTest {

    /*
    File :
        1. an object of File is a file or a directory.
        2. File Class is in java.io.*;

    Object File:
        1. get instance
            - File(String filePath)
        2. path:
            absolute path:
            relative path:
   File :
        if we wanna modify the content in file, we should use Stream
     */

    @Test
    public void test1() {
        // Get instance
        File file1 = new File("Hello.txt");
        File file2 = new File("E:\\workspaces\\IDEAWorkspace\\JavaSenior\\Java13\\he.txt");
        // Here file1 & file2 is just an object in internal storage

        File file3 = new File("E:\\workspaces", "IDEAWorkspaces");

        File file4 = new File(file3, "Hi.txt");
        System.out.println(file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n");
    }


    /*
    - For file
        public String getAbsolutePath();
        public String getPath();
        public String getName();
        public String getParent();
        public long length();
        public long lastModified();

    - For directory
        public String[] list();
        public File[] listFiles();

    - For file
        public boolean renameTo(File dest);
     */
    @Test
    public void test2() {
        // public String getAbsolutePath();
        File file1 = new File("Hello.txt");
        File file2 = new File("F:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println("-----------------------------");

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test3() {
        File file = new File("E:\\workspaces\\IDEAWorkspace\\JavaSenior");
        String[] list = file.list();

        for (String str : list) {
            System.out.println(str);
        }

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    @Test
    public void test4() {
        // public boolean renameTo(File dest) ; rename file.
        // file1.renameTo(file2);
        // if we wanna get "true", file1 exists and file2 not exist.
        File file1 = new File("Hello.txt");
        File file2 = new File("F:\\io\\Hi1.txt");

        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }

    /*
    public boolean isDirectory()
    public boolean isFile();
    public boolean exists();
    public boolean canRead();
    public boolean canWrite();
    public boolean isHidden();
     */

    @Test
    public void test5() {
        File file = new File("He.txt");
//        file = new File("He1.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        System.out.println();
        File file2 = new File("F:\\io");
//        file2 = new File("F:\\io1");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /*
    - For create file or directory
        public boolean createNewFile();
        public boolean mkdir();
        public boolean mkdirs();
    - For delete file or directory in hard disk
        public boolean delete();
     */
    @Test
    public void test6() throws IOException {
        File file = new File("Hi.txt");
//        System.out.println(file.exists());
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            if (newFile) {
                System.out.println("Create successfully");
            }
        } else{
            boolean delete = file.delete();
            if (delete) {
                System.out.println("Delete successfully");
            }
        }
    }

    @Test
    public void test7() {
        // Directory
        File file = new File("F:\\io\\io1\\io3");
        // mkdir():
        // if parent is not exist, it will not create.

        boolean mkdir = file.mkdir();
        if (mkdir) {
            System.out.println("Create successfully");
        }
        File file1 = new File("F:\\io\\io1\\io4");

        // mkdirs():
        // if parent is not exist, create parent and itself.

        boolean mkdirs = file1.mkdirs();
        if (mkdirs) {
            System.out.println("Create successfully2");
        }

    }
}
