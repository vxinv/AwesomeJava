package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

// 动态规划
public class q53_最大子序和_03 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        int pre = dp[0];
        for (int i = 1; i < len; i++) {
            int curr;
            if (pre > 0) {
                curr = pre + nums[i];
            } else {
                curr = nums[i];
            }
            res = Math.max(res,curr);
            pre = curr;
        }
        return res;
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
