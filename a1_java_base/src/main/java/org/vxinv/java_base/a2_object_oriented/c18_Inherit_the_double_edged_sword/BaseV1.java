package org.vxinv.java_base.a2_object_oriented.c18_Inherit_the_double_edged_sword;

// 4.4 为什么说继承是把双刃剑

public class BaseV1 {
	private static final int MAX_NUM = 1000;
	private int[] arr = new int[MAX_NUM];
	private int count;

	public void add(int number){
		if(count<MAX_NUM){
			arr[count++] = number;
		}
	}

	public void addAll(int[] numbers){
		for(int num : numbers){
			add(num);
		}
	}
}




