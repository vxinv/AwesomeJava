package org.vxinv.algorithm.多线程;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lixin
 * @date 2021/5/31
 * @description:
 */
public class Ticek {

    public static volatile AtomicInteger piao = new AtomicInteger(100);
    public static Lock lock = new ReentrantLock();

    static Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            while (piao.get() > 0) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (lock.tryLock() && piao.get() > 0) {
                    System.out.println("sleep 3s " + piao.get());
                    piao.getAndDecrement();
                    lock.unlock();
                }
            }

        }
    };
    static Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            while (piao.get() > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (lock.tryLock() && piao.get() > 0) {
                    System.out.println("sleep 5s " + piao.get());
                    piao.getAndDecrement();
                    lock.unlock();
                }
            }

        }
    };
    static Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            while (piao.get() > 0) {
                try {
                    Thread.sleep(70);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (lock.tryLock() && piao.get() > 0) {
                    System.out.println("sleep 7s " + piao.get());
                    piao.getAndDecrement();
                    lock.unlock();
                }
            }
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable3);
        t1.start();
        t2.start();
        t3.start();
       /* try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


}
