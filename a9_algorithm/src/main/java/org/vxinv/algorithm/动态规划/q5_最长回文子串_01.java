package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 回文的意思是正着念和倒着念一样，如：上海自来水来自海上
 */
class q5_最长回文子串_01 {
    public String longestPalindrome(String s) {
        // dp[i,j] i: 左边界 j: 右边界 均为左闭右闭,表示 左边界到右边界回文de值
        // dp[i,j] = dp[i-1][j-1] + 1;abcba 去掉a和a,b和b仍回文
        // 限制条件: i-j > 2 0--1--2--3
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n <= 2) {
            if (n <= 1) {
                return s;
            } else if (cs[0] == cs[1]) {
                return s;
            } else {
                return String.valueOf(cs[0]);
            }
        }
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        int begin = 0;
        // 付初始值
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                if (i == i1) {
                    dp[i][i1] = true;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (cs[i] != cs[j]){
                    dp[i][j] = false;
                } else  {
                    if (j - i < 3 ){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j-i+1 > max){
                    max = j-i+1;
                    begin = i;
                }
            }
        }
        String substring = s.substring(begin, begin + max);
        return substring.equals("")
                ? s.substring(0,1) : substring;
    }

    @Test
    public void test01() {
        System.out.println(longestPalindrome("aa"));
    }

    @Test
    public void test02() {
        System.out.println(longestPalindrome("ac"));
    }

    @Test
    public void test03() {
        System.out.println(longestPalindrome("abaaaavfee"));
    }

    @Test
    public void test04() {
        System.out.println(longestPalindrome("ccccc"));
    }

    @Test
    public void test05() {
        System.out.println(longestPalindrome("ccc"));
    }

    @Test
    public void test06() {
        System.out.println(longestPalindrome("ababa"));
    }
}
