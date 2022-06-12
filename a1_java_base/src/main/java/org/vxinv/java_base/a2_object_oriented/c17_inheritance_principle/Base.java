package org.vxinv.java_base.a2_object_oriented.c17_inheritance_principle;

// 4.3 继承实现的基本原理
public class Base {

	public static int s;
	private int a;

	static {
		s = 1;
		System.out.println("基类静态代码块, s: "+s);
	}

    {
        a = 1;
        System.out.println("基类实例代码块, a: " + a);
    }

    public Base() {
        a = 2;
        System.out.println("基类构造方法, a: " + a);
    }

    public void onlyBaseDo() {
        System.out.println(this.getClass().getName());
        System.out.println("a= " + a);
    }


    protected void step() {
        System.out.println("base s: " + s + ", a: " + a);
    }

    public void action() {
        System.out.println("start");
        step();
        System.out.println("end");
    }
}

