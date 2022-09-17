package org.vxinv.algorithm.双指针遍历;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Hash+双指针滑动窗口 o(n)
 */
public class q3_无重复字符的最长子串_01 {

    Logger log = LoggerFactory.getLogger(q3_无重复字符的最长子串_01.class);

    public int lengthOfLongestSubstring(String s) {
        int head = 0;
        int tail = 0;
        int max = 0;
        int[] map = new int[256];
        while (head < s.length()){
            while ( tail <= head && head < s.length() && !hasDu(s,tail,head,map)){
                if (head - tail + 1 > max) max = head -tail + 1;
                head++;
            }
            tail++;
        }
        return max;
    }

    public boolean hasDu(String s,int tail,int head,int[] map){
        Arrays.fill(map,0);
        String substring = s.substring(tail, head+1);
        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
            if (map[c] == 1) return true;
            map[c] = 1;
        }
        return false;
    }

    @Test
    public void test02(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
