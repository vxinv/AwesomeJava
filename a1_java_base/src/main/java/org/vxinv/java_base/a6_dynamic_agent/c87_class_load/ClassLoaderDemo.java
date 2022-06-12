package org.vxinv.java_base.a6_dynamic_agent.c87_class_load;

public class ClassLoaderDemo {

	public static void main(String[] args) {

        ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
        while (cl != null) {
            System.out.println(cl.getClass().getName());
            cl = cl.getParent();
        }

        System.out.println(String.class.getClassLoader());
    }

}
