package org.vxinv.algorithm.栈相关.q224_基本计算器.f3my;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        //　防止第一个为负号
        nums.push(0);
        // 去掉所有空格
        s = s.replace(" ", "");
        char[] cs = s.toCharArray();
        // 存放所有de字符
        int n = cs.length;
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ops.add(c);
            } else if (c == ')') {
                // 计算到最近一个左括号
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }

                }
            } else if (Character.isDigit(c)) {
                int u = 0;
                int j = i;
                // 数字可能是多位 全部取出连续数字
                while (j < n && Character.isDigit(cs[j])) {
                    u = u * 10 + (int) (cs[j++] - '0');
                }
                nums.addLast(u);
                i = j - 1;
            } else {
                if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                    System.out.println("line use");
                    nums.add(0);
                }
                // 新操作入栈,把栈内可以算的全算了 防止没有使用括号的参与计算
                while (!ops.isEmpty() && ops.peekLast() != '(') {
                    calc(nums, ops);
                }
                ops.addLast(c);
            }
        }

        while (!ops.isEmpty()) calc(nums, ops);
        return nums.peekLast();
    }

    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);
    }

    @Test
    public void test01() {
        int calculate = calculate(" 2-1 + 2 ");
        System.out.println(calculate);
    }

    @Test
    public void test02() {
        int calculate = calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate);
    }
}
