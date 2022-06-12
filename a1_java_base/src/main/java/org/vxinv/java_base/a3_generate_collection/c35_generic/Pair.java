package org.vxinv.java_base.a3_generate_collection.c35_generic;

public class Pair<U, V> {

    U first;
    V second;

    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }


    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
