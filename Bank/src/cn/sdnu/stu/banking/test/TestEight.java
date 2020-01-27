package cn.sdnu.stu.banking.test;

import cn.sdnu.stu.banking.domain.Bank;
import cn.sdnu.stu.banking.domain.CheckingAccount;
import cn.sdnu.stu.banking.domain.Customer;
import cn.sdnu.stu.banking.domain.SavingAccount;
import cn.sdnu.stu.banking.repors.CustomerReport;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:13 PM
 */
/*
 * This class creates the program to test the banking classes.
 * It creates a set of customers, with a few accounts each,
 * and generates a report of current account balances.
 */

public class TestEight {

    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        Customer customer;
        CustomerReport report = new CustomerReport();

        // Create several customers and their accounts
        bank.addCustomer("Jane", "Simms");
        customer = bank.getCustomer(0);
        customer.setSaving(new SavingAccount(500.00, 0.05));
        customer.setChecking(new CheckingAccount(200.00, new SavingAccount(400.00)));

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustomer(1);
        customer.setChecking(new CheckingAccount(200.00));

        bank.addCustomer("Tim", "Soley");
        customer = bank.getCustomer(2);
        customer.setSaving(new SavingAccount(1500.00, 0.05));
        customer.setChecking(new CheckingAccount(200.00));

        bank.addCustomer("Maria", "Soley");
        customer = bank.getCustomer(3);
        // Maria and Tim have a shared checking account
        customer.setChecking(bank.getCustomer(2).getChecking());
        customer.setSaving(new SavingAccount(150.00, 0.05));

        // Generate a report
        report.generateReport();
    }
}
