package org.vxinv.algorithm.动态规划;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 求出不同路径,选最小,由于只能向下或者向右,因此无论到
 * 任何位置,dp[i][j]都是dp[i-][j] 或 dp[i][j-1]走来的
 * 因此dp[i][j]表示走到此位置的 最小值
 * 得: dp[i][j] = Min(dp[i-1][j],dp[i][j-1])+1;
 * 满足无后效性;dp表 从上面右面获取下一步的解,可以从i
 * 到j循环
 */
public class q64_最小路径和_01 {
    public int minPathSum(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[i+1][j+1];
        // 设置初始值 当在从左到右方向第一行走,只能来自右边
        for (int j1 = 1; j1 <= j; j1++) {
            dp[1][j1] = dp[1][j1-1] + grid[0][j1-1];
        }
        for (int i1 = 2; i1 <= i; i1++) {
            dp[i1][1] += dp[i1-1][1] + grid[i1-1][0];
        }

        for (int ip = 2; ip < i+1; ip++) {
            for (int jp = 2; jp < j+1; jp++) {
                dp[ip][jp] = Math.min(dp[ip - 1][jp], dp[ip][jp - 1])+ grid[ip-1][jp-1];
            }
        }
        return dp[i][j];
    }
    @Test
    public void test1(){
        int[][] g= {{1,3,1},{1,5,1},{4,2,1}};
        int n = minPathSum(g);
        Assertions.assertEquals(n, 7);
    }
    // {{1,2,3},{4,5,6}}
    @Test
    public void test2(){
        int[][] g= {{1,2,3},{4,5,6}};
        int n = minPathSum(g);
        System.out.println(n);
    }
}
