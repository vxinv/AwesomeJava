package org.vxinv.algorithm.排序算法;

import java.util.Arrays;

/**
 * 快速排序
 * 随便选择一个数字作为基数 p
 * 标记最左边和最右边的数分别是 L R
 * L ++ 向 R 移动,当遇到某个数 大于 P 停止移动
 * R -- 向 L 移动,当遇到某个数 小于P 停止移动
 * L 和 R 交换
 * 当 R 和 L 相遇 ,那么 这个数 和 P 交换
 * 对左边和右边进行 如上 相同的操作
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 34, 45, 14, 115, 1, 5, 17, 71, 63, 23, 44, 4, 56, 9, 16, 5, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 快速排序
     *
     * @param arr
     * @param L   指向数组第一个元素
     * @param R   指向数组最后一个元素
     */
    public static void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;
        //支点
        int pivot = arr[(L + R) / 2];
        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {
            //寻找直到比支点大的数
            while (pivot > arr[i])
                i++;
            //寻找直到比支点小的数
            while (pivot < arr[j])
                j--;
            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。
        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < j)
            quickSort(arr, L, j);
        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R)
            quickSort(arr, i, R);
    }
}
