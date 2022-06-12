package org.vxinv.java_base.a5_juc;


/**
 * @author lixin
 * @date 2021/6/24
 * @description:
 */
public class LockTest {
    static class Lock{}

    public static void main(String[] args) {
        sleep(5000);
        Lock lock = new Lock();

        System.err.println("无锁");
        print(lock);

        synchronized (lock) {
            //main线程首次竞争锁，可偏向
            System.err.println("偏向锁");
            print(lock);
        }

        new Thread(()->{
            synchronized (lock){
                //线程A来竞争，偏向线程ID不是自己，升级为：轻量级锁
                System.err.println("轻量级锁");
                print(lock);
            }
        },"Thread-A").start();

        sleep(2000);

        new Thread(()->{
            synchronized (lock){
                sleep(1000);
            }
        },"Thread-B").start();

        //确保线程B启动并获得锁，sleep 100毫秒


        synchronized (lock){
            //main线程竞争时，线程B还未释放，多线程同时竞争，升级为：重量级锁
            System.err.println("重量级锁");
            print(lock);
        }
    }

    static void print(Object o){
        System.err.println("==========对象信息开始...==========");
        //System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //jol异步输出，防止打印重叠，sleep1秒
        sleep(1000);
        System.err.println("==========对象信息结束...==========");
    }

    static void sleep(long l){
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
