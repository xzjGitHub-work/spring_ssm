package com.myself.annotations.test;

import com.myself.annotations.MyAnnotations;
import com.myself.annotations.NameScanner;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/2/24 15:42
 */
@NameScanner
public class test {
    @Test
    @MyAnnotations(name = "1111")
    public void test02() {
        System.out.println("name");
    }


    @Test
    @NameScanner
    public void test03() {
        System.out.println("221312");
    }

    /**
     * @describe:注解处理器
     * @author:xzj
     * @createDate:2021/2/24 15:25
     * @param:[clazz]
     * @return:void
     */
    public void parseMethod(final Class<?> clazz) throws Exception {
        final Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});

        final Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods) {
            final MyAnnotations my = method.getAnnotation(MyAnnotations.class);
            if (null != my) {
                method.invoke(obj, my.name());
            }
        }
    }
}
