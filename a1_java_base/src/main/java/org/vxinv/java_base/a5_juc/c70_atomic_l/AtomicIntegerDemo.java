package org.vxinv.java_base.a5_juc.c70_atomic_l;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private static final AtomicInteger counter = new AtomicInteger(0);

    static class Visitor extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        }
    }

	public static void main(String[] args) throws InterruptedException {
		int num = 1000;
		Thread[] threads = new Thread[num];
		for (int i = 0; i < num; i++) {
			threads[i] = new Visitor();
			threads[i].start();
		}
		for (int i = 0; i < num; i++) {
			threads[i].join();
		}
		System.out.println(counter.get());
	}
}
