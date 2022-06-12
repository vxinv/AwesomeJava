package org.vxinv.java_base.a7_common_class.c36_thread_local;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lixin
 * @date 2021/6/16
 * @description:
 */
public class MyThreadLocalOOM1 {
    public static final Integer SIZE = 500;
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>());

    static class LocalVariable {//总共有5M
        private byte[] locla = new byte[1024 * 1024];
    }
    public static void main(String[] args) {
        try {
            for (int i = 0; i < SIZE; i++) {
                executor.execute(() -> {
                    new LocalVariable();
                    System.out.println("开始执行");
                });
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
