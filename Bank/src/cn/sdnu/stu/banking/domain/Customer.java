package cn.sdnu.stu.banking.domain;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:55 PM
 */
public class Customer {

    private String firstName;

    private String lastName;

    private SavingAccount savingAccount;

    private CheckingAccount checkingAccount;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public SavingAccount getSaving() {
        return savingAccount;
    }

    public void setSaving(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public CheckingAccount getChecking() {
        return checkingAccount;
    }

    public void setChecking(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }
}
