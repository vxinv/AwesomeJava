package org.vxinv.java_base.a2_object_oriented.c18_Inherit_the_double_edged_sword;

public class ChildV1 extends BaseV1 {

	private long sum;

	@Override
	public void add(int number) {
		sum+=number;
	}

	@Override
	public void addAll(int[] numbers) {
		for(int i=0;i<numbers.length;i++){
			sum+=numbers[i];
		}
	}

	public long getSum() {
		return sum;
	}
}
