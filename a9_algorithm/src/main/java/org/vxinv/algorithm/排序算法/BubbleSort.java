package org.vxinv.algorithm.排序算法;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


/**
 * 冒泡排序
 */

public class BubbleSort {

    static Logger log = LoggerFactory.getLogger(BubbleSort.class);


    public static void main(String[] args) {
        log.info("开始");
        int[] arr = {3, 34, 45, 14, 115, 1, 5, 17, 71, 63, 23, 44, 4, 56, 9, 16, 5, 3};
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

}
