package org.vxinv.java_base.a5_juc.b66_synchronized_l;

public class Counter {

    private int count;

    public synchronized void incr(){
        count ++;
    }

    public synchronized int getCount() {
        return count;
    }

}
