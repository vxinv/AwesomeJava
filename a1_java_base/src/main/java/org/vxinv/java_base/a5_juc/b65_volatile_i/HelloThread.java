package org.vxinv.java_base.a5_juc.b65_volatile_i;

public class HelloThread extends Thread {

	@Override
    public void run() {
		System.out.println("thread name: "+ Thread.currentThread().getName());
        System.out.println("hello");
    }

	public static void main(String[] args) {
	    Thread thread = new HelloThread();
	    thread.start();
	}
}
