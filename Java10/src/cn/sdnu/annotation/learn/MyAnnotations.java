package cn.sdnu.annotation.learn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 2:39 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
