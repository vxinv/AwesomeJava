package org.vxinv.java_base.a2_object_oriented.c21_inner_class.method;

public class Outer {

    private int a = 100;

    public void test(final int param){
        final String str = "hello";
        class Inner {
            public void innerMethod(){
                System.out.println("outer a " +a);
                System.out.println("param " +param);
                System.out.println("local var " +str);
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

}
