package org.vxinv.java_base.a6_dynamic_agent.c87_class_load;

public class MyClassLoaderDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		MyClassLoader cl1 = new MyClassLoader();
		String className = "shuo.laoma.dynamic.c87.HelloService";
		Class<?> class1 = cl1.loadClass(className);

		MyClassLoader cl2 = new MyClassLoader();
		Class<?> class2 = cl2.loadClass(className);

		if (class1 != class2) {
		    System.out.println("different classes");
		}
	}

}
