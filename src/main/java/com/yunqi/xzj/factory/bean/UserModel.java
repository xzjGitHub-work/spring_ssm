package com.yunqi.xzj.factory.bean;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/2/1 9:25
 */
public class UserModel {
    public String getUserModel(){
        System.out.println("访问到了");
        return "你好,工厂设计模式";
    }
}
