package org.vxinv.java_base.a5_juc.b65_volatile_i;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Thread helloThread = new Thread(new HelloRunnable());
        helloThread.start();
    }
}
