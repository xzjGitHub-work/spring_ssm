package com.test.demo01;

import com.alibaba.fastjson.JSONObject;
import com.myself.annotations.MyAnnotations;
import com.myself.domain.Account;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/2/20 9:55
 */
public class demo002 {
    @Test
    public void test01() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("14");
        List<String> stringList = list.stream().filter(o -> o.equals("14")).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(stringList));
        System.out.println(JSONObject.toJSONString(list));

    }


}
