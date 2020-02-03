package cn.sdnu.reflection.learn2;

import java.io.Serializable;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 12:52 PM
 */
public class Creature<T> implements Serializable {
    private char gender;

    protected String str;
    public double weight;

    private void breath() {
        System.out.println("Creature breath");
    }

    public void eat() {
        System.out.println("Creature eat");
    }
}
