package com.myself.lock;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockTest01 {
    // ------------------------- 悲观锁的调用方式 -------------------------

    /**
     * 测试悲观锁
     */
    @Test
    public void test01() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //悲观锁
                modifyPublicResources();
                System.out.println("悲观锁11执行了");
            }
        }, "LOCK_ONE").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //悲观锁
                modifyPublicResources();
                System.out.println("悲观锁22执行了");
            }
        }, "LOCK_TWO").start();

        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // synchronized
    public synchronized void testMethod() {
        log.info("============={}:悲观锁开始=============", Thread.currentThread().getName());
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 操作同步资源
        log.info("============={}:悲观锁结束=============", Thread.currentThread().getName());
    }

    // ReentrantLock
    private ReentrantLock lock = new ReentrantLock(); // 需要保证多个线程使用的是同一个锁

    public void modifyPublicResources() {
        //枷锁
        lock.lock();
        // 操作同步资源
        testMethod();
        //释放锁
        lock.unlock();
    }

    // ------------------------- 乐观锁的调用方式 -------------------------
    private AtomicInteger atomicInteger = new AtomicInteger();  // 需要保证多个线程使用的是同一个AtomicInteger

    /**
     * 测试乐观锁
     */
    @Test
    public void test02() {
        //乐观锁
        new Thread(new Runnable() {
            @Override
            public void run() {
                AtomicInteger integer = new AtomicInteger();
                JSONObject json = optimisticLock(integer);
                integer = json.getObject("data", AtomicInteger.class);
                while (!json.getBoolean("result")) {
                    json = optimisticLock(integer);
                }
                log.info("结束：{}", Thread.currentThread().getName());
            }
        }, "Thread_ONE").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                AtomicInteger integer = new AtomicInteger();
                JSONObject json = optimisticLock(integer);
                integer = json.getObject("data", AtomicInteger.class);
                while (!json.getBoolean("result")) {
                    json = optimisticLock(integer);
                }
                log.info("结束：{}", Thread.currentThread().getName());
            }
        }, "Thread_TWO").start();

        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public JSONObject optimisticLock(AtomicInteger atom) {
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{}线程执行了", Thread.currentThread().getName());
        JSONObject jsonObject = new JSONObject();
        if (atom.get() == atomicInteger.get()) {
            System.out.println("有资格执行");
            atomicInteger.incrementAndGet(); //执行自增1
            jsonObject.put("result", true);
            jsonObject.put("data", atomicInteger);
            return jsonObject;
        } else {
            System.out.println("无资格执行");
            jsonObject.put("result", false);
            jsonObject.put("data", atomicInteger);
            return jsonObject;
        }

    }
}
