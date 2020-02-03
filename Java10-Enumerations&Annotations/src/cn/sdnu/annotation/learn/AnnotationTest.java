package cn.sdnu.annotation.learn;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 11:50 AM
 */
public class AnnotationTest {

    /*
    Annotation use :
        Annotation is the special mark in the code. these marks will make sense when code is compiling, load class, running and so on.
    - used to javadoc
    - replaced by configuration file.

    Customized Annotation :
        - use keyword @interface to define Annotation
        - set field, generally using value.
        - set default value using keyword "default".
        - if there is no field, this is a mark.

    if there is field in your annotation, you should enter the value for your annotation when you use it.
    Generally, if we define a customized annotation, we specify two meta annotation (Retention, Target).
    HOWEVER, there is no sense that I defined the annotation "MyAnnotation".

    Meta-Annotation :
        - from jdk5.0, there are four meta annotations, Retention, Target, Documented, Inherited.
            - Retention :  modify the annotation's lifecycle, SOURCE\CLASS(default action)\RUNTIME(only this lifecycle, it can be read reflectively);
            - Target : where we can use TYPE\FIELD\METHOD\PARAMETER\CONSTRUCTOR\LOCAL_VARIABLE\PACKAGE\TYPE_PARAMETER(since 1.8)\TYPE_USE(since 1.8)
            - Documented : the annotation will be retained while being parsed by javadoc
            - Inherited : the subclass will have the annotation from superclass.

        - jdk8 :
            - Repeatable Annotation:
            - Type Annotation :
     */

    public static void main(String[] args) {
        Person p = new Person();
        p.test();
    }

}

interface Info {
    void test();
}


//@MyAnnotation
// before jdk 8.0
//@MyAnnotations(values = {@MyAnnotation(value = "hwllo"), @MyAnnotation(value = "Hwllo")})

// After jdk8.0, using @Repeatable
@MyAnnotation
@MyAnnotation("World")
class Person implements Info {
    @Override
    public void test() {
        System.out.println("Hello world");
    }
}
