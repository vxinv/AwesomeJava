package org.vxinv.java_base.a1_basic_logic.c12_function_use;

public class Recur {
	public static int factorial(int n) {
	    if(n==0){
	        return 1;
	    }else{
	        return n*factorial(n-1);
	    }
	}

	public static void main(String[] args) {
	    int ret = factorial(4);
	    System.out.println(ret);
	}

}
