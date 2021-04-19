package com.test.proxy.userdaoproxyjdk;

public class UserDao implements IUserDao{

    @Override
    public void save() {
        System.out.println("保存数据");
    }
}