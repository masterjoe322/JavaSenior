package cn.sdnu.reflection.learn4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 11:18 AM
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        HumanActions superMan = new SuperMan();
        HumanActions newInstance = ProxyBusiness.getNewInstance(superMan);
        newInstance.eat("Noodles");
        String belief = newInstance.getBelief();
        System.out.println(belief);

        System.out.println("*********************");

        ClothFactory nike = new NikeClothFactory();
        ClothFactory likeNike = ProxyBusiness.getNewInstance(nike);
        likeNike.produceCloth();
    }

}

interface HumanActions {
    void eat(String food);

    String getBelief();
}

class SuperMan implements HumanActions {

    @Override
    public void eat(String food) {
        System.out.println("I like " + food);
    }

    @Override
    public String getBelief() {
        return "I believe my dream will come true";
    }
}

class ProxyBusiness {
    @SuppressWarnings("unchecked")
    public static <E> E getNewInstance(E t) {
        MyInvocationHandler handler = new MyInvocationHandler(t);
        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), handler);
        return (E) o;
    }
}
// 2074387216

class MyInvocationHandler implements InvocationHandler {

    private Object object;
//
//    public void bind(Object object) {
//        this.object = object;
//    }

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util = new HumanUtil();
        util.method1();
        Object invoke = method.invoke(object, args);
        util.method2();
        return invoke;
    }
}

class HumanUtil {
    public void method1() {
        System.out.println("#############general method 1############");
    }

    public void method2() {
        System.out.println("#############general method 2############");
    }
}