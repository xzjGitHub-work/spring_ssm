package com.myself.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/2/24 15:20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    String name() default "xuzhaoju";
}
