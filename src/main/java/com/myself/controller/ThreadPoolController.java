package com.myself.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 多线程任务测试类:
 *
 * 1.使用Spring提供的线程池ThreadPoolTaskExecutor执行线程任务.
 * 2.通过set方法传递参数.
 * 3.使用Future对象封装返回值.
 * 4.将每一个任务类使用@Autowired注解，交给Spring管理.
 *
 * @author shiyanjun
 */
@Controller
@RequestMapping(value = "/thread/pool/test")
public class ThreadPoolController {
    @Autowired
    private ThreadPoolTaskExecutor poolTaskExecutor;

    /**
     * 根据ehrId获取档案
     * 请求路径示例：http://localhost:8080/phis/app/thread/pool/test/ehr/5065a1f1-c990-47f5-a58b-dd8fb240c215
     * @return
     */
    @RequestMapping(value = "/thread", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String download(String id) throws Exception{

        System.out.println(id);
        poolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("线程执行le "+Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            System.out.println("线程"+Thread.currentThread().getName());
            Thread.sleep(1000);
        }
        return "success";
    }
}