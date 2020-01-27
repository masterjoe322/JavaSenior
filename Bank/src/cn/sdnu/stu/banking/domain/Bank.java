package cn.sdnu.stu.banking.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:32 PM
 */
public class Bank {

    private static ReentrantLock lock = new ReentrantLock();
    private List<Customer> customers;
    private static Bank bank;

    private Bank() {
        customers = new ArrayList<>();
    }


    public static Bank getInstance() {
        if (bank == null) {
            lock.lock();
            try{
                if (bank == null) {
                    bank = new Bank();
                }
            } finally {
                lock.unlock();
            }
        }
        return bank;
    }

    public void addCustomer(String firstName, String lastName){
        Customer customer = new Customer(firstName, lastName);
        customers.add(customer);
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public int getNumberOfCustomers() {
        return customers.size();
    }

    public Iterator<Customer> getCustomers() {
        return customers.iterator();
    }
}
