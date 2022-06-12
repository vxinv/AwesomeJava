package org.vxinv.java_base.a2_object_oriented.c23_enmu_class;

// 5.4 枚举
public class Demo {

	static void onChosen(Size size){
	    switch(size){
	    case SMALL:
	        System.out.println("chosen small"); break;
	    case MEDIUM:
	        System.out.println("chosen medium"); break;
	    case LARGE:
	        System.out.println("chosen large"); break;
		default:

	    }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
