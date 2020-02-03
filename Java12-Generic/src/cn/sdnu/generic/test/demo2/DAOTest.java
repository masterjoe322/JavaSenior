package cn.sdnu.generic.test.demo2;

import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 8:52 PM
 */
public class DAOTest
{

    public static void main(String[] args) {
        DAO<User> dao = new DAO<User>();

        dao.save("1001", new User(1001, 34, "Jay Chou"));
        dao.save("1002", new User(1002, 20, "Kun Ling"));
        dao.save("1003", new User(1003, 30, "Yil Cai"));

        dao.update("1003", new User(1003, 30, "Wenshan Fang"));
        dao.delete("1002");

        List<User> list = dao.list();
        list.forEach(System.out::println);
    }
}
