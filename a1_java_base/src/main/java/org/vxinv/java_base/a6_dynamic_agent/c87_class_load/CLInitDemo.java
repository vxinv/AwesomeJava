package org.vxinv.java_base.a6_dynamic_agent.c87_class_load;

public class CLInitDemo {

	public static class Hello {
		static {
			System.out.println("hello");
		}
	};

	public static void main(String[] args) {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		String className = CLInitDemo.class.getName() + "$Hello";
		try {
			// loadClass 不执行静态方法
			Class<?> cls = cl.loadClass(className);
//			Class<?> cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
