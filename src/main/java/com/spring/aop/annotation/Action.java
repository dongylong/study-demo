package com.spring.aop.annotation;

import java.lang.annotation.*;

/**
 * @author dongyl
 * @date 14:02 5/15/18
 * @project study-demo
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
