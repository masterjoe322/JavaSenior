package cn.sdnu.jdk8.practice;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 6:57 PM
 */
@FunctionalInterface
public interface FunctionLike<T, R> {
    R getValue(T t, T tt);
}
