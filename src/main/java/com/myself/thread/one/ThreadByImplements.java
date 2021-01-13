package com.myself.thread.one;
/*线程共包括一下5种状态：

1. 新建、初始状态（New） ：线程对象被创建后就进入了新建状态，Thread thread = new Thread();
2. 就绪（Runnable）：也被称之为“可执行状态”，当线程被new出来后，其他的线程调用了该对象的start()方法，即thread.start()，此时线程位于“可运行线程池”中，只等待获取CPU的使用权，
        随时可以被CPU调用。进入就绪状态的进程除CPU之外，其他运行所需的资源都已经全部获得。
3. 运行（Running）：线程获取CPU权限开始执行。注意：线程只能从就绪状态进入到运行状态。
4. 阻塞（Bloacked）：阻塞状态是线程因为某种原因放弃CPU的使用权，暂时停止运行，知道线程进入就绪状态后才能有机会转到运行状态。
阻塞的情况分三种：
等待阻塞：运行的线程执行wait()方法，该线程会释放占用的所有资源，JVM会把该线程放入“等待池中”。进入这个状态后是不能自动唤醒的，
        必须依靠其他线程调用notify()或者notifyAll()方法才能被唤醒。
同步阻塞：运行的线程在获取对象的（synchronized）同步锁时，若该同步锁被其他线程占用，则JVM会吧该线程放入“锁池”中。
其他阻塞：通过调用线程的sleep()或者join()或发出了I/O请求时，线程会进入到阻塞状态。当sleep()状态超时、join()
        等待线程终止或者超时、或者I/O处理完毕时，线程重新回到就绪状态
5. 死亡（Dead）：线程执行完了或因异常退出了run()方法，则该线程结束生命周期。*/


import com.myself.DesignMode.SingletonDemo;

/**
 * @Description: 继承方式实现线程
 * @Author: xzj
 * @CreateDate: 2021/1/11 9:36
 */
public class ThreadByImplements implements Runnable {
    @Override
    public void run() {
        System.out.println("继承方式的线程执行了");
        SingletonDemo demo = SingletonDemo.getSingletonDemo();
        demo.setName("修改了");

    }
}

/**
 * @describe: 继承的方式
 * @author:xzj
 * @createDate:2021/1/11 9:45
 * @param:
 * @return:
 */
class ThreadByExtend extends Thread {
    @Override
    public void run() {
        System.out.println("继承方式的线程执行了");
        yield();
        System.out.println("yield");
    }
}

/**
 * @describe:测试
 * @author:xzj
 * @createDate:2021/1/11 9:46
 * @param:
 * @return:
 */
class Test {
    public static void main(String[] args) {
        //threadByExtend存放在栈中：实际threadByExtend存放的是堆中的地址值
        //new ThreadByExtend存放在堆中();
        ThreadByExtend threadByExtend = new ThreadByExtend();
        threadByExtend.setPriority(10);
        System.err.println("继承方式线程优先等级" + threadByExtend.getPriority());
        threadByExtend.start();
        ThreadByImplements threadByImplements = new ThreadByImplements();
        System.err.println("实现的方式线程优先等级：");
        threadByImplements.run();
//        ThreadByImplements.class
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName());
    }


    class TestPool {
        public void UseThreadPool() {
//            new ThreadPoolExecutor();
        }
    }
}