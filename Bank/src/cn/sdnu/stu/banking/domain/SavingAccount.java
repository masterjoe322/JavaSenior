package cn.sdnu.stu.banking.domain;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:46 PM
 */
public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public SavingAccount(double balance) {
        super(balance);
    }
}
