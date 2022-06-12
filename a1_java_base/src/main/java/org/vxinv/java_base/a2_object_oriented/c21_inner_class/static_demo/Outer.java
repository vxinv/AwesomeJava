package org.vxinv.java_base.a2_object_oriented.c21_inner_class.static_demo;

public class Outer {

    private static int shared = 100;

    public static class StaticInner {
        public void innerMethod(){
            System.out.println("inner " + shared);
        }
    }

    public void test(){
        StaticInner si = new StaticInner();
        si.innerMethod();
    }
}
