package org.vxinv.java_base.a7_common_class.c36_thread_local;

/**
 * @author lixin
 * @date 2021/6/16
 * @description:
 */
public class ThreadLocalMD {
    static ThreadLocal<Integer> integerThreadLocal =  new ThreadLocal<Integer>();
    public static void main(String[] args) {
        integerThreadLocal.set(0);

    }
}
