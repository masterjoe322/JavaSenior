package cn.sdnu.stream.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * MyInput.java : Contain the methods for reading int, double, float, boolean, short, byte and
 * string values from the keyboard
 *
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 11:16 AM
 */
public class MyInput {

    /**
     * Read a string from the keyboard
     *
     * @return a string from the keyboard
     */
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Declare and initialize the string
        String s = "";

        // Get the string from the keyboard
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return the string obtained from the keyboard
        return s;
    }

    /**
     * return an int value from the keyboard
     *
     * @return an int value from the keyboard
     */
    public static int readInt() {
        return Integer.parseInt(readString());
    }

    /**
     * return a double value from the keyboard
     *
     * @return a double value from the keyboard
     */
    public static double readDouble() {
        return Double.parseDouble(readString());
    }

    /**
     * return a float value from the keyboard
     *
     * @return a float value from the keyboard
     */
    public static float readFloat() {
        return Float.parseFloat(readString());
    }

    /**
     * return a long value from the keyboard
     *
     * @return a long value from the keyboard
     */
    public static long readLong() {
        return Long.parseLong(readString());
    }

    /**
     * return a short value from the keyboard
     *
     * @return a short value from the keyboard
     */
    public static short readShort() {
        return Short.parseShort(readString());
    }

    /**
     * return a byte value from the keyboard
     *
     * @return a byte value from the keyboard
     */
    public static byte readByte() {
        return Byte.parseByte(readString());
    }

    /**
     * return a boolean value from the keyboard
     *
     * @return a boolean value from the keyboard
     */
    public static boolean readBoolean() {
        return Boolean.parseBoolean(readString());
    }
}
