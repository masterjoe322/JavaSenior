package cn.sdnu.stu.banking.test;

import cn.sdnu.stu.banking.domain.Bank;
import cn.sdnu.stu.banking.domain.Customer;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:38 PM
 */
/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */


public class TestBank {

    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        // Add Customer Jane, Simms
        //code
        bank.addCustomer("Jane", "Simms");
        //Add Customer Owen, Bryant
        //code
        bank.addCustomer("Owen", "Bryant");
        // Add Customer Tim, Soley
        //code
        bank.addCustomer("Tim", "Soley");
        // Add Customer Maria, Soley
        //code
        bank.addCustomer("Maria", "Soley");
        for (int i = 0; i < bank.getNumberOfCustomers(); i++) {
            Customer customer = bank.getCustomer(i);

            System.out.println("Customer [" + (i + 1) + "] is "
                    + customer.getLastName()
                    + ", " + customer.getFirstName());
        }
    }
}

