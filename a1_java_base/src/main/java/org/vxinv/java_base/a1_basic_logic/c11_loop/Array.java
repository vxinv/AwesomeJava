package org.vxinv.java_base.a1_basic_logic.c11_loop;

public class Array {

	public static void reset(int[] arr){
	    for(int i=0;i<arr.length;i++){
	        arr[i] = i;
	    }
	}

	public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        reset(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }

}
