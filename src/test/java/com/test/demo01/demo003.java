package com.test.demo01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/4/14 9:47
 */
public class demo003 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(format.format(Calendar.getInstance().getTime()));
            }
        },1000,2000);//1秒后开始调度 每2秒执行一次
    }
}
