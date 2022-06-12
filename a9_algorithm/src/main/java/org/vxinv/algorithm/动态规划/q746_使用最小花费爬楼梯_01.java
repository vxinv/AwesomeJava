package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 示例 1：
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 定义dp数组：dp[i] 表示当前 上到第i个台阶的最小花费
 * dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
 * 当前在i-1个台阶和在i-2个台阶的花费
 */
class q746_使用最小花费爬楼梯_01 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];


        int min_cost0 = 0;
        int min_cost1 = 0;
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < len + 1; i++) {
            dp[i] += Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            min_cost0 = dp[i];
        }
        // 判断 i==2  走哪个更好
        if (cost[0] > cost[0] + cost[1]) {
            return min_cost0;
        } else {
            // 直接走一比较好 减去从台阶0到台阶1的花费
            return min_cost0 - cost[0];
        }
    }

    @Test
    public void test01() {
        int t = minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(t);
    }

    @Test
    public void test02() {
        int t = minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println(t);
    }
}
