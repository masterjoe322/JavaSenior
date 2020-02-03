package cn.sdnu.generic.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 5:49 PM
 */
public class SubOrder1 extends Order<Integer> {

    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> es = new ArrayList<>(Arrays.asList(arr));
        return es;
    }

}
