package org.vxinv.java_base.a5_juc.b66_synchronized_l;

public class StaticCounter {
    private static int count = 0;

    public static synchronized void incr() {
        count++;
    }

    public static synchronized int getCount() {
        return count;
    }
}
