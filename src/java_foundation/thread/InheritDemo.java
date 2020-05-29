package java_foundation.thread;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class InheritDemo {
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    static @interface Test {

    }

    @Test
    static class Base {

    }

    /**
     * 子类可以用到父类的 Inherited 注解
     */
    static class Chilld extends Base {

    }

    public static void main(String[] args) {
        System.out.println(Chilld.class.isAnnotationPresent(Test.class));
    }
}
