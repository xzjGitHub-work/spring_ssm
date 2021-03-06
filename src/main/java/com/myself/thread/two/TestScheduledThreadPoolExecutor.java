package com.myself.thread.two;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPoolExecutor {

    /**
     * @describe:创建一个定长线程池.支持定时及周期性任务执行
     *
     * @author:xzj
     * @createDate:2021/1/12 10:39
     * @param:[args]
     * @return:void
     */
    public static void main(String[] args) {
 
        ScheduledThreadPoolExecutor exec =new ScheduledThreadPoolExecutor(2);
 
        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间就触发异常
 
                      @Override
 
                      public void run() {
 
                           //throw new RuntimeException();
 
                           System.err.println("================");
 
                      }
 
                  }, 1000, 5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间打印系统时间，证明两者是互不影响的
 
                      @Override
 
                      public void run() {
 
                           System.out.println(System.nanoTime());
 
                      }
 
                  }, 1000, 2000, TimeUnit.MILLISECONDS);
 
    }
 
}