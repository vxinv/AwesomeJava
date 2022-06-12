package org.vxinv.java_base.a5_juc.b66_synchronized_l;

public class Counter2 {
    private int count;

    public void incr(){
        synchronized(this){
            count++;
        }
    }

    public int getCount() {
        synchronized(this){
            return count;
        }
    }
}
