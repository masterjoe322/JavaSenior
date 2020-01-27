package cn.sdnu.stu.banking.exceptions;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:19 PM
 */
public class OverdraftException extends Exception {

    private double deficit;

    public OverdraftException(double deficit) {
        this.deficit = deficit;
    }

    public OverdraftException(String message) {
        super(message);
    }

    public double getDeficit() {
        return deficit;
    }
}
