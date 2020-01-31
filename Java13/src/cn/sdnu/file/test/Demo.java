package cn.sdnu.file.test;

import org.junit.Test;

import java.io.File;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 9:05 AM
 */
public class Demo {
    @Test
    public void testDeleteFileByName() {
        File file = new File("F:\\io");
        boolean b = deleteFileByName("hi.txt.bak", file);
        System.out.println(b);
    }

    @Test
    public void testPrintJPEG() {
        File f = new File("D:\\");
        printJPEG(f);
    }

    @Test
    public void testPrintAllFiles() {
        File f = new File("E:\\");
        printAllFiles(f);
    }

    /**
     * delete file by file name
     *
     * @param fileName the name of specified file will be deleted
     * @param file     parent directory of the file will be deleted
     * @return {@code true} delete successfully, {@code false} delete failed
     */
    private boolean deleteFileByName(String fileName, File file) {
        File file1 = new File(file, fileName);

        if (file1.exists()) {
            boolean delete = file1.delete();
            if (delete) {
                return true;
            }
        }
        return false;
    }

    /**
     * If file is directory, print the absolute path of the file whose extension is ".jpg"
     *
     * @param file the specified directory
     */
    public void printJPEG(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        printJPEG(f);
                    } else {
                        if (f.getAbsolutePath().endsWith(".jpg")) {
                            System.out.println(f.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    /**
     * print all the absolute paths of all files in the specified directory
     *
     * @param file
     */
    public void printAllFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        printAllFiles(f);
                    } else {
                        System.out.println(f.getAbsolutePath());
                    }
                }
            }
        }
    }
}
