package cn.sdnu.generic.test;

import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:53 PM
 */
public class DAO<T> {
    // DAO : data(base) access object.
    // Add one record
    public void add(T t) {

    }

    // Delete one record
    public boolean remove(int index) {
        return false;
    }

    // Update one record
    public void update(int index, T t) {

    }

    // Query one record
    public T getIndex(int index) {
        return null;
    }

    // Query more than one record
    public List<T> getForList() {
        return null;
    }

    // Generic method
    // Example: Get length of the records in one table.
    // Example: Get the max birthday of all the Employee.
    public <E> E getValue() {
        return null;
    }
}
