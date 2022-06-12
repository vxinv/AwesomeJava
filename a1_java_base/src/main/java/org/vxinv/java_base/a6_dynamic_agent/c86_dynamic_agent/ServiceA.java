package org.vxinv.java_base.a6_dynamic_agent.c86_dynamic_agent;

import org.vxinv.java_base.a6_dynamic_agent.c85_annotation.SimpleInject;

public class ServiceA {

    @SimpleInject
    ServiceB b;

    public void callB() {
        b.action();
    }

    public ServiceB getB() {
        return b;
    }


}
