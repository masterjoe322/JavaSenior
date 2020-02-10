package cn.sdnu.jdk8.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:12 PM
 */
public class OptionalTest {
    @Test
    public void test1() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> girl1 = Optional.of(girl);
        System.out.println(girl1);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        Optional<Object> empty = Optional.empty();
//        System.out.println(empty);
        Optional<Girl> girl1 = Optional.ofNullable(null);
        System.out.println(girl1);
    }

    @Test
    public void test3() {
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("Ping"));
        String name = getName(boy);
        System.out.println(name);
    }

    public String getName(Boy boy) {
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        Boy meng = boy1.orElse(new Boy(new Girl("Meng")));
        Optional<Girl> girl = Optional.ofNullable(meng.getGirl());
        Girl girl1 = girl.orElse(new Girl("Qiu"));
        return girl1.getName();
    }

}
