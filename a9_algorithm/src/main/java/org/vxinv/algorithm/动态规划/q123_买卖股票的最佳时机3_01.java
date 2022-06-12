package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

public class q123_买卖股票的最佳时机3_01 {
    public int maxProfit(int[] prices) {
        int i0 = 0; // 初始值(没有买过没有卖过)
        int b1 = 1; // 第一次买
        int s1 = 2; // 第一次卖
        int b2 = 3; // 第二次买`
        int s2 = 4; // 第二次卖
        int n = prices.length;
        int[][] dps = new int[n][5];

        // 不可能出现值 第二天出现第三次买卖
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                if (i1  > i) {
                    dps[i][i1] = Integer.MIN_VALUE/2;
                }
            }
        }
        // 设置初始值
        for (int i = 0; i < n; i++) {
            dps[i][i0] = 0; // 任何一天只要没买卖 利润都是0
            dps[i][b1] = -prices[i]; //任何一天只要是第一次买 利润都是-price[i]
        }
        // 向 左上方开始计算
        for (int i = 1; i < n; i++) {
            dps[i][b1] = Math.max((dps[i - 1][b1]), (dps[i - 1][i0] - prices[i]));
            dps[i][s1] = Math.max((dps[i - 1][b1] + prices[i]), (dps[i - 1][s1]));
            dps[i][b2] = Math.max((dps[i - 1][b2]), (dps[i - 1][s1] - prices[i]));
            dps[i][s2] = Math.max((dps[i - 1][s2]), (dps[i - 1][b2] + prices[i]));
        }
        int b = Math.max(dps[n - 1][2], dps[n - 1][4]);
        return Math.max(b, 0);
    }

    @Test
    public void test01() {
        int[] ins = {1, 2, 3, 4, 5};
        int i = maxProfit(ins);
        System.out.println(i);
    }

    @Test
    public void test02() {
        int[] ins = {3, 3, 5, 0, 0, 3, 1, 4};
        int i = maxProfit(ins);
        System.out.println(i);
    }

    @Test
    public void test03() {
        int[] ins = {7, 6, 4, 3, 1};
        int i = maxProfit(ins);
        System.out.println(i);
    }

    @Test
    public void test04() {
        int[] ins = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(ins);
        System.out.println(i);
    }
}
