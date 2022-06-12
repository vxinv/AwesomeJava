package org.vxinv.java_base.a5_juc.b71_ReentrantLock_Demo;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread (){
	        @Override
			public void run(){
	            LockSupport.park();
	            System.out.println("exit");
	        }
	    };
	    t.start();
	    Thread.sleep(1000);
		System.out.println(t.getState());
	    LockSupport.unpark(t);

	}

}
