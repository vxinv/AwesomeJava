package org.vxinv.java_base.a6_dynamic_agent.c86_dynamic_agent;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect({ ServiceB.class })
public class ExceptionAspect {
	public static void exception(Object object,
			Method method, Object[] args, Throwable e) {
        System.err.println("exception when calling: " + method.getName()
                + "," + Arrays.toString(args));
    }
}
