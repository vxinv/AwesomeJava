package org.vxinv.java_base.a2_object_oriented.c18_Inherit_the_double_edged_sword;

public class TestUtils {

//	public static void main(String[] args) {
//		Child c = new Child();
//		c.addAll(new int[]{1,2,3});
//		System.out.println(c.getSum());
//	}

	/**
	 * 基类的调用 会调用父类的方法
	 * @param args
	 */
	public static void main(String[] args) {
		ChildV1 c = new ChildV1();
		c.addAll(new int[]{1,2,3});
//		c.clear();
//		c.addAll(new int[]{1,2,3});
		System.out.println(c.getSum());
	}
}
