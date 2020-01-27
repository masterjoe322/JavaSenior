package cn.sdnu.stu.banking.repors;

import cn.sdnu.stu.banking.domain.Bank;
import cn.sdnu.stu.banking.domain.Customer;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 1:59 PM
 */
public class CustomerReport {

    public static void generateReport() {
        Bank bank = Bank.getInstance();

        System.out.println("           CUSTOMER REPORT           ");
        System.out.println("=====================================");

        for (int i = 0; i < bank.getNumberOfCustomers(); i++) {
            Customer customer = bank.getCustomer(i);
            System.out.println("Customer [" + customer.getLastName()
                    + ", " + customer.getFirstName() + "]");
            if (customer.getChecking() != null) {
                System.out.println("Checking Account: current balance is $" + customer.getChecking().getBalance());
            }
            if (customer.getSaving() != null) {
                System.out.println("Saving Account: current balance is $" + customer.getSaving().getBalance());
            }
            System.out.println();
        }

    }

}
