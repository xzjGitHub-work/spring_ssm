package com.myself.DesignMode;
/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/1/12 11:42
 *
 */
public class SingletonTest {
    public static void main(String[] args) {
        SingletonDemo singletonDemo = SingletonDemo.getSingletonDemo();
        System.out.println(singletonDemo);
    }
}
