package org.vxinv.algorithm.查找算法;

/**
 * 二分查找
 */
public class BinaryFind {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 6, 7, 8, 9, 10};

        int search = search(array, 2, 0, array.length - 1);
        System.out.println(search);
    }

    public static int search(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] > key) {
            return search(arr, key, low, mid - 1);
        } else if (arr[mid] < key) {
            return search(arr, key, mid + 1, high);
        } else {
            return mid;
        }
    }

}
