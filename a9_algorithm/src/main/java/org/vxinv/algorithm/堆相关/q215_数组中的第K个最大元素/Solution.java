package org.vxinv.algorithm.堆相关.q215_数组中的第K个最大元素;

import java.util.PriorityQueue;

/**
 * 利用大根堆实现 o(n*log(k))
 */
public class Solution {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k){
                heap.poll();
            }
        }

        return heap.poll();
    }

    public static void main(String[] args) {
        int[] testi = {11111111,13,44,5,5,5,5,8897,7762177,2222,222,22,12,2243,656,44,4554,22,4,3,243,2};
        int kthLargest = findKthLargest(testi, 3);
        System.out.println(kthLargest);
    }
}
