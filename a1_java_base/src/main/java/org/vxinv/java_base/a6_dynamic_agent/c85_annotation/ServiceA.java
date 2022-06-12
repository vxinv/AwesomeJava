package org.vxinv.java_base.a6_dynamic_agent.c85_annotation;

public class ServiceA {

	@SimpleInject
	ServiceB b;

	public void callB(){
		b.action();
	}

	public ServiceB getB() {
		return b;
	}


}
