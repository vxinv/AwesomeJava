package org.vxinv.java_base.a2_object_oriented.c18_Inherit_the_double_edged_sword;

public class ChildV4 {
	private BaseV1 base;
	private long sum;

	public ChildV4(){
		base = new BaseV1();
	}

	public void add(int number) {
		base.add(number);
		sum+=number;
	}

	public void addAll(int[] numbers) {
		base.addAll(numbers);
		for(int i=0;i<numbers.length;i++){
			sum+=numbers[i];
		}
	}

	public long getSum() {
		return sum;
	}
}
