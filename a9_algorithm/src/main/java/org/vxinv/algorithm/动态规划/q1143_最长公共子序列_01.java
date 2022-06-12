package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长
 * 的公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在
 * 不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符)
 * 后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde"
 * 的子序列。两个字符串的 公共子序列 是这两个字符串所共同拥有的
 * 子序列。
 * 示例 1：
 * <p>
 * 输入：text1 = "abcde", text2 = "acfge"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * <p>
 * 解:
 * 总结状态转移方程
 * dp[i][j]表示 c1{0->i}子组和 c2{0->j}子组的公共子串个数;
 * i/j表示从0->i/j的子串;
 * 当 c1[i]的字符 == c2[j],那么 dp[i-1][j-i]+1,既当前加入
 * 一个公共字符,因此需要将个数加1;
 * dp[i+1][j+1] = dp[i][j] + 1
 * 当 c1[i]的字符 != c2[j],那么c1{0->i}子组和c2{0->j}子组的
 * 最大公共串,等于 c1{0->i-1}子组和c2{0->j-1}的最大值;
 * dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1])
 * 由于长度i和数组i的差为一,dp[i][j] 加1,求和不需要减1
 */
public class q1143_最长公共子序列_01 {

    public int longestCommonSubsequence(String text1, String text2) {

        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int cl1 = c1.length;
        int cl2 = c2.length;
        int[][] dp = new int[cl1+1][cl2+1];

        for (int i = 0; i < cl1; i++) {
            for (int j = 0; j < cl2; j++) {
                if (c1[i] == c2[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[cl1][cl2];
    }
    @Test
    public void test(){
        int i = longestCommonSubsequence("abcde", "acfge");
        System.out.println(i);
    }
    @Test
    public void test2(){
        int i = longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
}
