package org.vxinv.java_base.a5_juc.b66_synchronized_l;

public class StaticCounter2 {

    private static int count = 0;

    public static void incr() {
        synchronized(StaticCounter.class) {
            count++;
        }
    }

    public static int getCount() {
        synchronized(StaticCounter.class){
            return count;
        }
    }

}
