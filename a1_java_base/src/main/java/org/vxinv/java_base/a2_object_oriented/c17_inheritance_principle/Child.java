package org.vxinv.java_base.a2_object_oriented.c17_inheritance_principle;

public class Child extends Base {
	public static int s;
	private int a;

	static {
		s = 10;
		System.out.println("子类静态代码块, s: "+s);

	}
	{
		a = 10;
		System.out.println("子类实例代码块, a: "+a);
	}

	public Child(){
		a = 20;
		System.out.println("子类构造方法, a: "+a);
	}

	@Override
	protected void step() {
        onlyBaseDo();
        System.out.println("child s: " + s + ", a: " + a);
    }
}

