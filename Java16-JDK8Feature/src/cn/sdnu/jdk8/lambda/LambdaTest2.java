package cn.sdnu.jdk8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 1:16 PM
 */
public class LambdaTest2 {

    @Test
    public void test1() {

        happyTime(23.0, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("money is " + aDouble);
            }
        });

        System.out.println("###################################################");

        happyTime(23.0, e -> System.out.println("money is " + e));


    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("Beijing", "Nanjing", "Tianjin", "Dongjing", "Xijing", "PuJing");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("jing");
            }
        });

        System.out.println(filterStrs);

        List<String> filterStrss = filterString(list, pre -> pre.contains("jing"));
        System.out.println(filterStrss);

    }

    /*
    According to the specified rule, filter the String in list, we will override the method in Predicate
     */
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                filterList.add(str);
            }
        }
        return filterList;

    }

}
