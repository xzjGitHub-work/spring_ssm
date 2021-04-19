package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/4/16 14:24
 */
public class SimpleProxyModelFactory {

    private SimpleProxyModelFactory(){};
    public static void getProxy(String[] args) {
        Proxy.newProxyInstance(ProxyObject.class.getClassLoader(), ProxyObject.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理成功");
                        return null;
                    }
                });
    }
}
