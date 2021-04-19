package com.test.demo01;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 多线程实现任务调度
 * @Author: xzj
 * @CreateDate: 2021/4/14 9:47
 */
public class demo003 {
    public final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    /**
     * @describe:timer实现定时任务
     *
     * @author:xzj
     * @createDate:2021/4/14 9:55
     * @param:[args]
     * @return:void
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(format.format(Calendar.getInstance().getTime()));
            }
        },1000,2000);//1秒后开始调度 每2秒执行一次
    }
    /**
     * @describe:juc ScheduledThreadPool实现任务调度
     *
     * @author:xzj
     * @createDate:2021/4/14 9:58
     * @param:[]
     * @return:void
     */
    @Test
    public void test01(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        pool.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(format.format(Calendar.getInstance().getTime()));
                    }
                }
        ,1,2, TimeUnit.SECONDS);
    }

    /**
     * @describe:quartz方式实现任务调度
     *
     * @author:xzj
     * @createDate:2021/4/14 10:02
     * @param:[]
     * @return:void
     */
    @Test
    public void test02() throws Exception {
        //创建一个Scheduler
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        //创建jobDetail
        JobBuilder job = JobBuilder.newJob(MyJob.class);
        job.withIdentity("jobName", "JobGroupName");
        JobDetail jobDetail = job.build();
        //创建触发的CronTrigger 支持按日历调度
//        TriggerBuilder.newTrigger()
//                .withIdentity("triggerName","triggerGroupName")
//                .startNow()
//                .withSchedule(CronScheduleBuilder.cronSchedule("cron语句"))
//                .build();
        //创建触发的SimpleTrigger 简单的时间调度
        TriggerBuilder.newTrigger()
                .withIdentity("triggerName","triggerGroupName")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

    }

    public class MyJob implements Job{
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

            System.out.println(format.format(Calendar.getInstance().getTime()));
        }
    }
}
