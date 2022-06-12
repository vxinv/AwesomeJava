package org.vxinv.java_base.a5_juc.c67_synchronzied_notify;

/**
 * 1 wait 只能在 synchronized 里面使用
 * 2 调用 wait 时 ，当前线程会 释放获取的锁
 * 3
 */
public class WaitThread extends Thread {

    private volatile boolean fire = false;

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!fire) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public synchronized void fire() {
        this.fire = true;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        waitThread.start();
        Thread.sleep(1000);
        System.out.println("fire");
        waitThread.fire();
    }
}
