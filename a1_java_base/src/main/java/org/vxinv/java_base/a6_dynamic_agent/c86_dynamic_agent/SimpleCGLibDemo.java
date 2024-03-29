package org.vxinv.java_base.a6_dynamic_agent.c86_dynamic_agent;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class SimpleCGLibDemo {
    public static void main(String[] args) throws Exception {
        RealService proxyService = getProxy(RealService.class);
        proxyService.sayHello();
        proxyService.sayWorld();
    }

    static class RealService {
        public void sayHello() {
            System.out.println("hello");
            sayWorld();
        }

        public void sayWorld() {
            System.out.println("World");
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor());
        return (T) enhancer.create();
    }

    static class SimpleInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = proxy.invokeSuper(object, args);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }
}
