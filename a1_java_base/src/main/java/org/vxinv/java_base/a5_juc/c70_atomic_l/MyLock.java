package org.vxinv.java_base.a5_juc.c70_atomic_l;

import java.util.concurrent.atomic.AtomicInteger;

public class MyLock {
    private AtomicInteger status = new AtomicInteger(0);

    public void lock() {
        while (!status.compareAndSet(0, 1)) {
            Thread.yield();
        }
    }

    public void unlock() {
        status.compareAndSet(1, 0);
    }
}
