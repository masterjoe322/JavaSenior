package cn.sdnu.jdk8.optional;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 4:17 PM
 */
public class Girl {
    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
