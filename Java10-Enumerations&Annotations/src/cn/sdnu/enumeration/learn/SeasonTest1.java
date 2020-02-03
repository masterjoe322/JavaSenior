package cn.sdnu.enumeration.learn;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 10:54 AM
 */
public class SeasonTest1 {

    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
        System.out.println(Season1.class.getSuperclass());

    }

}

enum Season1 implements Info {

    // 1. provide objects we will use, division with "," , finish with ";";
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里? ");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    // 2. field : definition with "private final"
    private final String name;

    private final String description;


    // 3. constructor privatization, initialize name and description
    private Season1(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }



/*    // toString()
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }*/
}
