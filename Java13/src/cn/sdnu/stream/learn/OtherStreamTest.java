package cn.sdnu.stream.learn;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 10:45 AM
 */
public class OtherStreamTest {
    /*
    Other Stream :
        - Standard Input & Output Stream
            - System.in: from keyboard
            - System.out: to console
            - System.setIn(InputStream is) / System.setOut(PrintStream ps) to modify new Stream
     */

    @Test
    public void test1() {
        // from keyboard, lowercase to uppercase
        // method1 : Using Scanner
        // method2 : Using System.in
        BufferedReader br = null;
        try {
            InputStream in = System.in;
            br = new BufferedReader(new InputStreamReader(in));
//            String s = "";
//            while ((s = br.readLine()) != null) {
//                if ("e".equals(s) || "exit".equals(s)) {
//                    break;
//                }
//                System.out.println(s.toUpperCase());
//            }
            while (true) {
                String s = br.readLine();
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    System.out.println("Exit");
                    break;
                }
                System.out.println(s.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        System.out.println("Enter a number");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
    }

    public static void main(String[] args) {
        // from keyboard, lowercase to uppercase
        // method1 : Using Scanner
        // method2 : Using System.in
        BufferedReader br = null;
        try {
            InputStream in = System.in;
            br = new BufferedReader(new InputStreamReader(in));
            String s = "";
            while ((s = br.readLine()) != null) {
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    System.out.println("EXIT!");
                    break;
                }
                System.out.println(s.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("F:\\IO\\text.txt"));
            ps = new PrintStream(fos, true);
            System.setOut(ps);
            for (int i = 0; i < 256; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println(); // new line
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }


    @Test
    public void test4() {
        /*
        Write String, fundamental data type in internal storage into file.
         */
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("Hello4.txt"));
//            dos.writeUTF("Jianchen");
            dos.writeBytes("Jianchen");
            dos.flush();
            dos.writeInt(23);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test5() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("Hello4.txt"));

            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("isMale = " + isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
