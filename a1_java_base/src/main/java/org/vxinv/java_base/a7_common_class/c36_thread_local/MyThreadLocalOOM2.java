package org.vxinv.java_base.a7_common_class.c36_thread_local;

import org.vxinv.java_base.a9_encode_decode.ThreadPoll.MyThreadFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lixin
 * @date 2021/6/16
 * @description:  ThradLocal 避免内存泄漏
 */
public class MyThreadLocalOOM2 {
    public static final Integer SIZE = 1000;
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(),
            new MyThreadFactory.SelfDefinedThreadFactory("my poll"));

    static class LocalVariable {//总共有5M
        private byte[] locla = new byte[1024 * 1024 * 5];
    }

    public static void main(String[] args) {
            for (int i = 0; i < SIZE; i++) {
                executor.execute(() -> {
                    ThreadLocal<LocalVariable> local = new ThreadLocal<>();
                    local.set(new LocalVariable());
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    try {
                        Thread.sleep(1000);
                        System.out.println(local.get().toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //local.remove();
                });
                //local.remove();
            }
            //local = null;//这里设置为null，依旧会造成内存泄漏
        }
    }


