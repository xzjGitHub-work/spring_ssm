package com.myself.utils;

import java.lang.reflect.Method;

/**
 * @Description:利用反射调取get、set方法
 * @Author: xzj
 * @CreateDate: 2021/1/19 11:39
 */
public class ReflectionUtil {

    public Object TakeItGet(Class objectClass, String fieldName) throws NoSuchMethodException {
        StringBuffer sb = new StringBuffer();
        sb.append("get");
        Method method = objectClass.getMethod(sb + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
        return null;
    }

    public static void main(String[] args) {
        String name = "sssss";
        String s = name.substring(0, 1).toUpperCase();
        System.out.println(s);
        System.out.println(name.substring(1));
    }
}
