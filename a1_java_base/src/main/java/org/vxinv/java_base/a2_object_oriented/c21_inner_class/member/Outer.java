package org.vxinv.java_base.a2_object_oriented.c21_inner_class.member;

public class Outer {
    private int a = 100;

    public class Inner {
        public void innerMethod(){
            System.out.println("outer a " +a);
            Outer.this.action();
        }
    }

    private void action(){
        System.out.println("action");
    }

    public void test(){
        Inner inner = new Inner();
        inner.innerMethod();
    }

}
