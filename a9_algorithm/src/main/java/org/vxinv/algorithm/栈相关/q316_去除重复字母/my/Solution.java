package org.vxinv.algorithm.栈相关.q316_去除重复字母.my;

import org.junit.Test;

import java.util.Stack;

/**
 * 栈操作 o(n*log(n))
 */
public class Solution {

    public String removeDuplicateLetters(String s) {
        // ascii 256个元素
        int[] count = new int[256];
        boolean[] inStack = new boolean[256];
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            count[aChar]++;
            // inStr[aChar] = true;
        }
        for (char aChar : chars) {
            count[aChar]--;
            // 栈里面没有
            if (!inStack[aChar]) {
                // 当前 栈顶大于 索引值,并且栈顶元素 后面还有,就可以弹出 然后继续
                while ( !stack.empty() && stack.peek() > aChar && count[stack.peek()] > 0 ){
                    inStack[stack.peek()] = false;
                    stack.pop();
                }
                stack.push(aChar);
                inStack[aChar] = true;
            }

        }
        String rs = "";

        for (int i = 0; i < stack.size(); i++) {
            rs += stack.get(i);
        }
        return rs;
    }

    /** c b a c d c b c
     *  加 c  栈中是: c
     *  加 b ; b > c ; 栈顶c后 > 0 pop(c) push(b)  栈中是: b
     *  加 a ; b > a, 栈顶b后 > 0; pop(b) push(a) 栈中: a
     *  加 C ; a < c, push(c) 栈中 a - c
     *  加 d;  c < d,push(d) 栈中 a-
     *  c - d
     *  加 C; c 存在,跳过,这一步因为该栈已经是单调递增的,所以后面的字典序大
     *  的要放在最低位置 栈中  a - c - d
     *  加 b; d > b ,b后 !> 0,push(b) a-c-d-b
     *  加 C; c 存在,跳过
     *  结束
     */
    @Test
    public void test01() {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
