package com.myself.utils;

import com.myself.domain.Account;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/2/1 9:47
 */
public class CycleOperationField {

    /**
     * 方法作用描述：循环实体操作字段
     *
     * @return void
     * @author xzj
     * @createDate 2020/9/22 17:00
     */
    @Test
    public void test08() throws Exception {
        Account account = new Account();
        account.setName("100");
        account.setId(1);
        account.setMoney("100");
        account.setAge(1D);
        Account o = (Account) encryptBean(account.getClass(), account);
        System.out.println();
        String name = o.getName();
        System.out.println(AesUtil.decryptHex(name));
        System.out.println(o);

    }


    public Object encryptBean(Class aClass, Object o) throws Exception {
        //获取到所有的字段
        Field[] fields = aClass.getDeclaredFields();
        List<Method> setMethods = new ArrayList<>();
        List<Method> getMethods = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            //获取字段名
            String convert = getConvert(fields[i].getName());
            //拼接方法名称
            if (fields[i].getType().toString().contains("java.lang.String")) {
                setMethods.add(aClass.getDeclaredMethod("set" + convert, String.class));
                getMethods.add(aClass.getDeclaredMethod("get" + convert));
            }
        }
        //循环所有的方法
        for (int i = 0; i < getMethods.size(); i++) {
            setMethods.get(i).invoke(o, AesUtil.encryptHex((String)getMethods.get(i).invoke(o)));
        }
        return o;
//        return null;
    }
    //
    public static String getConvert(String str) {
        String first = str.substring(0, 1);
        String after = str.substring(1); //substring(1),获取索引位置1后面所有剩余的字符串
        first = first.toUpperCase();
        return first + after;
    }
}
