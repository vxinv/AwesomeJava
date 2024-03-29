package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>21
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 两种情况
 * dp[i] = 从{0...i+1}取的最大值
 * 取i ：取i的话，不能取相邻，i-1，i+1；
 * dp[i] = dp[i-2] + nums[i]
 * 不取i： 可取dp【i-1]的最大值； 和nums[i+1]
 * dp[i] = dp[i-1]
 * 取不取需要比大小，状态转移使得 i= i -1
 * dp[i] = max(dp[i-2] + nums[i] ,dp[i-1] )
 */
class q198_打家劫舍_01 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 让 i 不超过数组范围，取 1
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    @Test
    public void test01() {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    public void test02() {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }
}
