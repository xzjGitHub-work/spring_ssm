package com.test.demo01;

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
        log.info("这是lombok的日志");
        log.error("这是lombok的日志");
        log.debug("这是lombok的日志");
        int i = 1;
        switch (1) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
        }
        str = null;
        System.out.println("".isEmpty());
        System.out.println(StringUtils.isEmpty(str));
        System.out.println(StringUtils.cleanPath(str1));
        System.out.println(str1);
    }
}
