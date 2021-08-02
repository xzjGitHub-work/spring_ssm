package com.myself.annotations.test02;

import java.lang.annotation.*;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/6/2 10:05
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface SPI {

}
