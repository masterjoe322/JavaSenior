package cn.sdnu.list.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:39 PM
 */
public class ListDemo {

    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);

        System.out.println(list);
    }

    private void updateList(List list) {
//        list.remove(2);
        list.remove(new Integer(2));

        // if there is one integer in method remove(),
        // so Integer is index, not an object.
    }


}
