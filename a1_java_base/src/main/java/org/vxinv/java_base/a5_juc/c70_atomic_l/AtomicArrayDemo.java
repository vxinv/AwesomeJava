package org.vxinv.java_base.a5_juc.c70_atomic_l;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicArrayDemo {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        AtomicIntegerArray atomicArr = new AtomicIntegerArray(arr);
        atomicArr.compareAndSet(1, 2, 100);
        System.out.println(atomicArr.get(1));
        System.out.println(arr[1]);
    }

}
