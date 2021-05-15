package com.test.demo01;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/1/13 11:39
 */
@Slf4j
public class demo001 {
    private Serializable creator;
    private String str;
    private String str1 = "111";

    public Serializable getCreator() {
        return creator;
    }

    public void setCreator(Serializable creator) {
        this.creator = creator;
    }

    @Test
    public void test01() {
        String s ="[\n" +
                "    [\"lxwz\",\n" +
                "        {\"indexName\":\"guowang_lxwz\",\n" +
                "         \"paramList\":[{\"prodCatBigId,prodCatMidId,prodCatSmallId\":\"cg,22023,22023020\"},\n" +
                "                      {\"prodBrandId\":\"00020746\"},\n" +
                "                      {\"storeId\":\"597E4D47AE98A778\"}\n" +
                "                    ],\n" +
                "         \"prodId\":\"0007043002\",\n" +
                "         \"size\":9,\n" +
                "         \"userId\":\"068cfa247c044851a4caa9acb7450a38\"\n" +
                "        }\n" +
                "    ] \n" +
                "\n" +
                "]\n";
        System.out.println(JSONObject.toJSONString(s));
    }


}
