package cn.sdnu.stu.banking.domain;

import cn.sdnu.stu.banking.exceptions.OverdraftException;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:47 PM
 */
public class CheckingAccount extends Account {

    private SavingAccount protectedBy;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(SavingAccount protectedBy) {
        this.protectedBy = protectedBy;
    }

    public CheckingAccount(double balance, SavingAccount protectedBy) {
        super(balance);
        this.protectedBy = protectedBy;
    }

    @Override
    public void withdraw(double withdraw) throws OverdraftException {
        if (withdraw < this.balance) {
            this.balance -= withdraw;
        } else {
            if (protectedBy != null) {
                if (withdraw < this.balance + protectedBy.getBalance()) {
                    double v = withdraw - this.balance;
                    protectedBy.withdraw(v);
                    this.balance = 0;
                } else {
                    throw new OverdraftException("Insufficient funds for overdraft protection");
                }
            } else {
//                throw new RuntimeException("No balance ");
                throw new OverdraftException("No checking Account");
            }
        }
    }

}


