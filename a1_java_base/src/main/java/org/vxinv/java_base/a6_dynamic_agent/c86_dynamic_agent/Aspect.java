package org.vxinv.java_base.a6_dynamic_agent.c86_dynamic_agent;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(RUNTIME)
@Target(TYPE)
public @interface Aspect {
	Class<?>[] value();
}

