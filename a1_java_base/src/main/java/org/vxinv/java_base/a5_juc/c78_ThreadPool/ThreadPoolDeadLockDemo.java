package org.vxinv.java_base.a5_juc.c78_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 如果任务A是提交给了一个单线程线程池，一定会出现死锁，A在等待B的结果，而B在队列中等待被调度。
 * 如果是提交给了一个限定线程个数的线程池，也有可能因线程数限制出现死锁
 */
public class ThreadPoolDeadLockDemo {
    private static final int THREAD_NUM = 5;
    static ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

    static class TaskA implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 提交B B在线程池中等待被调度
            Future<?> future = executor.submit(new TaskB());
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("finished task A");
        }
    }

    static class TaskB implements Runnable {
        @Override
        public void run() {
            System.out.println("finished task B");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            executor.execute(new TaskA());
        }
        Thread.sleep(2000);
        executor.shutdown();
    }

}
