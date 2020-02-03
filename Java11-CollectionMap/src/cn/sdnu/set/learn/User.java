package cn.sdnu.set.learn;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 3:11 PM
 */
public class User implements Comparable {

    private String name;

    private int age;

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User's equals()");

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    /**
     * Only compare by name from greater than less.
     *
     * @param o object we need to compare.
     * @return if result greater than 0, this is greater than o <br>
     * if result less than 0, this is less than o<br />
     * if result is 0, this is equals to o
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            return this.name.compareTo(user.name);
//            return Integer.compare(this.age, user.age);
        } else {
            throw new RuntimeException("Type Input Error");
        }

    }
}
