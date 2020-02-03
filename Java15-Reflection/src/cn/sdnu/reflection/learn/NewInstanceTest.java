package cn.sdnu.reflection.learn;

import org.junit.Test;

import java.util.Random;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 10:48 AM
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /*
        newInstance(): invoke this method, create object of this class.
        invoke the no argument constructor. if we have not the constructor without arguments or the constructor without arguments is private

        if we want to invoke newInstance() :
            1. we must have the constructor without argument
            2. we have reasonable right for constructor accessible

        Java Bean, we should have a constructor has no argument:
            1. convenient for reflection, create a new instance.
            2. when call super(), and the super class has it.
         */
        Person person = clazz.newInstance();
        System.out.println(person);

    }

    @Test
    public void test2() {
        int num = new Random().nextInt(3);

        String classPath = "";

        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.sql.Date";
                break;
            case 2:
                classPath = "cn.sdnu.reflection.learn.Person";
                break;
            default:
                classPath = "java.lang.Object";
                break;
        }

        Object instance = getInstance(classPath);
        System.out.println(instance);
    }

    /**
     * create a new instance of specified Name
     * @param classPath class name
     * @return an instance of the specified name
     */
    public Object getInstance(String classPath) {
        Object instance = null;
        try {
            Class<?> clazz = Class.forName(classPath);
            instance = clazz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
