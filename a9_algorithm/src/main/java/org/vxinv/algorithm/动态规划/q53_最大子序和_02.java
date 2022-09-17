package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 不使用数组
 */
public class q53_最大子序和_02 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE / 2;
        for (int j = 0; j < length; j++) {
            // 计算sum
            int sum = 0;
            for (int i = 0; i <= j; i++) {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
            for (int i = 0; i <= j; i++) {
                sum -= nums[i];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        // 处理
        if (max == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    max = nums[0];
                }
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }
        return max;
    }

    @Test
    public void test01() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);

    }

    @Test
    public void test02() {
        int[] nums = {-4, -11, -3};
        int i = maxSubArray(nums);
        System.out.println(i);

    }

    // [5,4,-1,7,8]
    @Test
    public void test03() {
        int[] nums = {5, 4, -1, 7, 8};
        int i = maxSubArray(nums);
        System.out.println(i);

    }
}
