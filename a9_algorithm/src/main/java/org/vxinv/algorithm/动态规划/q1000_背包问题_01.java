package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class q1000_背包问题_01 {
    /**
     * @param m 背包最大重量
     * @param n 商品个数
     * @param w 商品重量数组
     * @param p 商品价值数组
     * @return
     */
    public int backpack(int m, int n, int[] w, int[] p) {
        int[][] dp = new int[n + 1][m + 1]; // n: 装入了第i件 m: 装入的前i件的重量
        // 商品重量是0的情况
        for (int i = 0; i < n; i++) {
            dp[n][0] = 0;
        }
        // 不放任何物品的情况
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 当前商品的重量＜ 背包的重量,直接等于上一个
                // 如果第i件物品的重量大于背包容量j,则不装入背包
                // 由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + p[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    @Test
    public void test01() {
        int[] w = {3, 4, 5, 6};
        int[] p = {4, 5, 6, 7};
        int ans = backpack(10, 4, w, p);
        System.out.println(ans);
    }
}
