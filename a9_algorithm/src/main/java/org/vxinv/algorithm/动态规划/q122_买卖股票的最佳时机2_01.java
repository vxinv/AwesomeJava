package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出,
 * 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出,
 * 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * | | 7 | 1 | 5 | 3 | 6 | 4 |
 *
 * | 0 | 0 | 0 | 4 | 4 | 7 | 7 |
 * | 1 | -7 | -1 | -1 | 1 | 1 | 3 |
 *
 */
class q122_买卖股票的最佳时机2_01 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dps = new int[n][2];
        // 构造状态转移方程 dps[i][1/0] i: 当前的第n天; 0/1: 当前持有 1,不持有 0;
        // dps[i][j]值表示 当前的当前的收益
        dps[0][0] = 0; // 第一天不持有 为0
        dps[0][1] = -prices[0]; // 第一天持有为 -p[i];
        for (int i = 1; i < prices.length; i++) {
            // 当天不持有 = 昨天卖出 或 昨天不持有 往后递推也一样, 当前的昨天不持有
            // 可能是前天不持有 或者 前天卖出了
            dps[i][0] = Math.max((dps[i - 1][1] + prices[i]), (dps[i - 1][0]));
            dps[i][1] = Math.max((dps[i - 1][0] - prices[i]), (dps[i - 1][1]));
        }
        return dps[prices.length - 1][0];
    }

    @Test
    public void test01() {
        int[] ins = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(ins);
        System.out.println(i);
    }
}
