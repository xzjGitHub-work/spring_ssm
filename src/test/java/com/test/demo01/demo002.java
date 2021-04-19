package com.test.demo01;

import com.alibaba.fastjson.JSONObject;
import com.myself.annotations.MyAnnotations;
import com.myself.domain.Account;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;
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

    @Test
    public void test02() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key2", "value2");
        map.put("key3", "value3");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test03() {
        String nowTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        String nowDate = nowTime.substring(0, 10);
        System.out.println(nowDate);

    }

    @Test
    public void test04() {
        String a =" xzj";
        String b =" xzj";
        String c = new String("xzj");
        String d = new String("xzj");
        Object o = new Object();
        Object ob = new Object();
        System.out.println(o ==ob);
        System.out.println(o.equals(ob));
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == c);
        System.out.println(a.equals(c));
        System.out.println(c ==d );
        System.out.println(c.equals(d));

    }


}
