package org.vxinv.algorithm.动态规划;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。
 * 如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序
 * 的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3
 */
public class q1143_最长公共子序列_02 {
    public int longestCommonSubsequence(String text1, String text2) {
        LinkedList<Character> sc1 = new LinkedList<>();
        LinkedList<Character> sc2 = new LinkedList<Character>();
        char[] c1  = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int maxl = Math.max(c1.length,c2.length);
        for (int i = 0; i < maxl; i++) {
            if (c1.length > i){
                sc1.push(c1[i]);
            }
            if (c2.length > i){
                sc2.push(c2[i]);
            }
        }
        int t = 0;
        while (sc1.size() != 0 && sc2.size() != 0){
           Character cc1 =sc1.poll();
           Character cc2 = sc2.poll();
           while (!cc1.equals(cc2)){
               if (sc1.size() > sc2.size()){
                   cc1 = sc1.poll();
               }else {
                   cc2 = sc2.poll();
               }
           }
           t++;
        }
        return t;
    }
    @Test
    public void test(){
        int i = longestCommonSubsequence("abcdesd", "acfgecd");

        System.out.println(i);
    }
    @Test
    public void test2(){
        int i = longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
}
