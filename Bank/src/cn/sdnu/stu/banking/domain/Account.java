package cn.sdnu.stu.banking.domain;

import cn.sdnu.stu.banking.exceptions.OverdraftException;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:41 PM
 */
public class Account {

    protected double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double deposit) {
        this.balance += deposit;
        return true;
    }

    public void withdraw(double withdraw) throws OverdraftException {
        if (withdraw < this.balance) {
            this.balance -= withdraw;
        } else {
            throw new OverdraftException("Balance is not enough");
        }
    }

    public double getBalance() {
        return balance;
    }

}
