package cn.sdnu.reflection.learn4;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 10:21 AM
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        // Deputy class
        ClothFactory nike = new NikeClothFactory();
        // Proxy class
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        // Proxy result
        proxyClothFactory.produceCloth();
    }

}

interface ClothFactory {
    void produceCloth();
}

// Proxy
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory; // this is deputy class

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("Prepare to produce...");
        factory.produceCloth();
        System.out.println("Do the after work...");
    }
}

// Deputy

class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike produces some sports cloth");
    }
}
