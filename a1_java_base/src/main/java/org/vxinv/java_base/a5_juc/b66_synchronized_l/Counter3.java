package org.vxinv.java_base.a5_juc.b66_synchronized_l;

public class Counter3 {

    private int count;
    private Object lock = new Object();

    public void incr(){
        synchronized(lock){
            count++;
        }
    }

    public int getCount() {
        synchronized(lock){
            return count;
        }
    }
}
