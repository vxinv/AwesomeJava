package org.vxinv.java_base.a1_basic_logic.c11_loop;

public class Array {

	
	public static void reset(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		
		int[] arr = { 10, 20, 30, 40 };
		reset(arr);
		for (int j : arr) {
			System.out.println(j);
		}
		int[] arr1 = new int[5];
		for (int j = 0; j < 5; j++) {
			System.out.println(arr1[j]);
		}
	}

}
