package org.vxinv.java_base.a1_basic_logic.c12_function_use;

public class ArrayMax {

    public static int max(int min, int[] arr) {
        int max = min;
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4};
        int ret = max(0, arr);
        System.out.println(ret);
    }

}
