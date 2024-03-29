package org.vxinv.java_base.a6_dynamic_agent.c85_annotation;


public class ContainerDemo {

	public static void usingSimpleContainer(){
		ServiceA a = SimpleContainer.getInstance(ServiceA.class);
		a.callB();

        ServiceB b = SimpleContainer.getInstance(ServiceB.class);

        if(b != a.getB()){
			System.out.println("SimpleContainer: different instances");
		}
	}

    public static void usingSimpleContainer2(){
		ServiceA a = SimpleContainer2.getInstance(ServiceA.class);
		a.callB();

        ServiceB b = SimpleContainer2.getInstance(ServiceB.class);

        if(b == a.getB()){
			System.out.println("SimpleContainer2: same instances");
		}
	}

    public static void main(String[] args) {
		usingSimpleContainer2();
	}
}
