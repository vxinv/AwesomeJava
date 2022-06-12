
package org.vxinv.algorithm.多线程;

public class test2 {
    private static volatile int total = 100;

    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    while (total > 0) {
                        total--;
                        try {
                            System.out.println("窗口1：" + total);
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    while (total > 0) {
                        total--;
                        try {
                            System.out.println("窗口2：" + total);
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    while (total > 0) {
                        total--;
                        try {
                            System.out.println("窗口3：" + total);
                            Thread.sleep(70);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }
}
