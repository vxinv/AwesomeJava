package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」
 * 的前 numRows 行。在「杨辉三角」中，每个数
 * 是它左上方和右上方的数的和。
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * dp[i,j]: i表示第i行,j表示i行第j个,dp[i,j]表示i行
 * j个的数
 * dp[i,j] = dp[i-1,j]+dp[i-1,j+1];
 * 构建数组 n+1 * n+1 , 把左右仅有一个加的补零
 */
public class q118_杨辉三角_01 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arrayLists = new ArrayList<List<Integer>>();
        int[][] dp = new int[numRows + 2][numRows + 2];
        dp[0][1] = 1; // 实际第一 是数组第0列
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int nr = 1; nr <= i; nr++) {
                dp[i][nr] = dp[i - 1][nr - 1] + dp[i - 1][nr];
                integers.add(dp[i][nr]);
            }
            arrayLists.add(integers);
        }
        return arrayLists;
    }

    @Test
    public void test01() {
        System.out.println(generate(3));
    }
}
