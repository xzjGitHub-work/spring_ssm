package com.myself.DesignMode;

/**
 * @Description: 单例
 * @Author: xzj
 * @CreateDate: 2021/1/12 11:36
 */
public class SingletonDemo {
    private String name = "许兆举";
    private static SingletonDemo singletonDemo = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private SingletonDemo() {
    }

    public static SingletonDemo getSingletonDemo() {
        if (singletonDemo == null) {
            synchronized ("") {
                if (singletonDemo == null) {
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

}
