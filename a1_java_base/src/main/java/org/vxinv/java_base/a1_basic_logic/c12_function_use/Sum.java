package org.vxinv.java_base.a1_basic_logic.c12_function_use;

public class Sum {

	public static int sum(int a, int b) {
		int c = a + b;
		return c;
	}

	public static void main(String[] args) {
		int d = Sum.sum(1, 2);
		System.out.println(d);
	}
}
