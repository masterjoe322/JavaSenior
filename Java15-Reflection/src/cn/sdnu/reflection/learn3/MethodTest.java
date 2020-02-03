package cn.sdnu.reflection.learn3;

import cn.sdnu.reflection.learn2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:24 PM
 */
public class MethodTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        // getMethods() : get the public method of this class and its super class.
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println();
        // getDeclaredMethods() : get all the methods in current class
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    /*
    @Annotations
    modifier : return type : method name : arguments : XxxException{}
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            // 1. Get annotations on the methods
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }

            // 2. Get modifiers of the methods
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            // 3. Get return type of the methods
            Class<?> returnType = m.getReturnType();
            System.out.print(returnType.getName() + "\t");

            // 4. Get name of methods
            System.out.print(m.getName());

            // 5. Get arguments type of the methods
            System.out.print("(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i == parameterTypes.length - 1) {
                    System.out.print(parameterTypes[i].getName() + " args_" + i);
                    break;
                }
                System.out.print(parameterTypes[i].getName() + " args_" + i + ", ");
            }
            System.out.print(")");

            // 6. Get the Exceptions which has throws declaration
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            /*if (!(exceptionTypes == null && exceptionTypes.length == 0)) {
                System.out.print(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ", ");
                }
            }*/
            if (exceptionTypes.length > 0) {
                System.out.print(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ", ");
                }
            }

            System.out.println();
        }
    }

}
