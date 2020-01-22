package cn.sdnu.commonclass.learn;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 7:44 PM
 */
public class Goods implements Comparable{

    private String name;
    private Integer price;

    public Goods() {

    }

    public Goods(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Compare to the good according to price
     *
     * @param obj
     * @return
     */
    @Override
    public int compareTo(Object obj) {

        if (obj instanceof Goods) {
            Goods object = (Goods) obj;

            if (this.price > object.price) {
                return 1;
            } else if (this.price < object.price) {
                return -1;
            } else {
//                return 0;
                return this.name.compareTo(object.name);
            }

//            return Integer.compare(this.price, object.price);
        } else {
            throw new RuntimeException("the argument is not available!");
        }
    }

}
