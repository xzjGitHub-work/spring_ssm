package com.myself.test;

import lombok.Data;

import java.util.Objects;

/**
 * @Description
 * @Author ZJQ
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020-08-04
 */
@Data
public class UserInfo {
    private String name;

    private Integer age;

    private String address;

    public UserInfo(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(getName(), userInfo.getName()) &&
                Objects.equals(getAge(), userInfo.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}
