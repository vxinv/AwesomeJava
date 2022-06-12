package org.vxinv.java_base.a5_juc.Interrupt_Demo;

public class InterruptSynchronizedDemo {

    private static Object lock = new Object();

    private static class A extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                while (!Thread.currentThread().isInterrupted()) {
                }
            }
            System.out.println("exit");
        }
    }

    public static void test() throws InterruptedException {
        synchronized (lock) {
            A a = new A();
            // A 线程 blocked
            a.start();
            Thread.sleep(1000);
            System.out.println(a.getState());
            a.interrupt();
            a.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}


