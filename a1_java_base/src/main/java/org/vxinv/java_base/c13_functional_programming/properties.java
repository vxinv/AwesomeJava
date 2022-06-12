package org.vxinv.java_base.c13_functional_programming;

public class properties {
    public static void main(String[] args) {
        System.getProperties().forEach((t,w)->{
            System.out.println(t.toString());
            System.out.println(w.toString());
        });

    }
}
