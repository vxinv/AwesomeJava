package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 一个机器人位于一个 m x n (长\宽)网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
class q62_不同路径_01 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        // 设置初始值 上下方向只有一种走法
        for (int i = 1; i < n+1; i++) {
            dp[1][i] = 1;
        }
        // 左右方向
        for (int i = 1; i < m + 1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i < m+1; i++) {
            for (int j = 2; j < n+1; j++) {
                // 任何地方只有从上向下 或者从右向左
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];

    }

    @Test
    public void test01(){
        System.out.println(uniquePaths(3,7));
    }
}
