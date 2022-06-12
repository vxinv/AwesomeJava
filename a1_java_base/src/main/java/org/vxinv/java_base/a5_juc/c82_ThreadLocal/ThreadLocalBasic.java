package org.vxinv.java_base.a5_juc.c82_ThreadLocal;

/**
 * 线程本地变量是说，每个线程都有同一个变量的独有拷贝。这个概念听上去比较难以理解，我们先直接来看类TheadLocal的用法。
 */
public class ThreadLocalBasic {
	static ThreadLocal<Integer> local = new ThreadLocal<>();

	public static void main(String[] args) throws InterruptedException {
		Thread child = new Thread(() -> {
			System.out.println("child thread initial: " + local.get());
			local.set(200);
			System.out.println("child thread final: " + local.get());
		});
		local.set(100);
		child.start();
		child.join();
		System.out.println("main thread final: " + local.get());
	}
}
