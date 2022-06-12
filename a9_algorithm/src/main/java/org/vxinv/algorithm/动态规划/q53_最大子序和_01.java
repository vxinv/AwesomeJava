package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

/**
 * dp[i,j] 表示从 i到j的加和最大
 * 给你一个整数数组 nums ，请你找出一个
 * 具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class q53_最大子序和_01 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE/2;
        int length = nums.length;
        if (length == 1){
            return nums[0];
        }
        int[][] dp = new int[length][length];
        // 先循环j,后循环i,状态转移竖列推算
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {

                if (i == j){
                    dp[i][j] = nums[i];
                }else {
                    dp[i][j] = dp[i][j-1]+ nums[j];
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
    @Test
    public void test01(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);

    }
    @Test
    public void test02(){
        int[] nums = {-4,-11,-3};
        int i = maxSubArray(nums);
        System.out.println(i);

    }
    // [5,4,-1,7,8]
    @Test
    public void test03(){
        int[] nums = {5,4,-1,7,8};
        int i = maxSubArray(nums);
        System.out.println(i);

    }
}
