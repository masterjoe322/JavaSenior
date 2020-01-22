package cn.sdnu.enumeration.learn;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 10:38 AM
 */
public class SeasonTest {
    /*
    Enumeration :
        if objects are specified and limited, we can use enumeration class.
        singleton : enumeration

    How to use :
        1. before jdk 5.0, we use enumeration customized.
        2. jdk 5.0 : use keyword "enum" to define enumeration class and objects.

    Enum :
        1. toString() : return the name of the enumeration class
        2. values : return an array of all enumeration objects
        3. valueOf(String objName) : return an enumeration object with a name.

    About interface
        1. use keyword "enum" implements interface
            - implements the method defined in the interface we implemented.
            - for every different enumeration, we have different method implement.
                   AUTUMN("秋天", "秋高气爽") {
                        @Override
                        public void show() {
                            System.out.println("秋天不回来");
                        }
                    },
     */

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }


        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        Season1 winter = Season1.valueOf("WINTER"); // if there is no the object you enter, throw IllegalArgumentException.
        String description = winter.getDescription();
        System.out.println(description);
        System.out.println(winter);


    }

}

interface Info {
    public abstract void show();
}

class Season {

    // 1. field : definition with "private final"
    private final String name;

    private final String description;


    // 2. constructor privatization, initialize name and description
    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // 3. provide objects we will use
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // toString()


    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}