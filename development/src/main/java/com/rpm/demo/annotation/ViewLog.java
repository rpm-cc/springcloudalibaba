package com.rpm.demo.annotation;

import java.lang.annotation.*;

/**
 * @Author Piming Ren
 * @Date 2021/1/28 9:07
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ViewLog {

    String value() default "";
}
