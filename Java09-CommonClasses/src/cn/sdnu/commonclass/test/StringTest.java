package cn.sdnu.commonclass.test;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:47 PM
 */
public class StringTest {

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + " and " + String.valueOf(ex.ch)); // good and best

        /*
           address of  [str = new String("good")] to str,  str in the method is changed, but str[good] is not changed
         */
    }

}
