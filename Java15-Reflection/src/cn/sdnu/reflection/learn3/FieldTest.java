package cn.sdnu.reflection.learn3;

import cn.sdnu.reflection.learn2.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:09 PM
 */
public class FieldTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        // Get the public field of the class and its super class
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        // getDeclaredFields() : get all the field of current Class, exclusive field in super class
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field d : declaredFields) {
            System.out.println(d);
        }
    }

    /*
    modifier : type : variable name
     */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        for (Field f : fields) {
            // 1. modifier
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            // 2. variable type
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            // 3. variable name
            String name = f.getName();
            System.out.println(name + "\t");

            System.out.println();
        }

    }
}
