package org.vxinv.algorithm.栈相关.q227_基本计算器二.f1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};

    public int calculate(String s) {
        // 去掉空格
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        s = s.replace(" ", "");
        char[] chars = s.toCharArray();
        int n = chars.length;
        nums.add(0);
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peek() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pop();
                        break;
                    }
                }
            } else if (Character.isDigit(c)) {
                // 取出所有连续de数字
                int j = i;
                int u = 0;
                while (j < n && Character.isDigit(chars[j])) {
                    u = u * 10 + (chars[j++] - '0');
                }
                nums.push(u);
                i = j - 1;
                // 操作符运算
            } else {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    char pre = ops.peek();
                    if (map.get(pre) >= map.get(c)) {
                        calc(nums, ops);
                    } else {
                        break;
                    }
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty() && ops.peek() != '('){ calc(nums, ops);};
        return nums.peek();
    }

    public void calc(Stack<Integer> nums, Stack<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        char op = ops.pop();
        int b = nums.pop();
        int a = nums.pop();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        }
        if (op == '-') {
            ans = a - b;
        }
        if (op == '/') {
            ans = a / b;
        }
        if (op == '*') {
            ans = a * b;
        }
        if (op == '^') {
            ans = (int) Math.pow(a, b);
        }
        if (op == '%') {
            ans = a % b;
        }
        nums.push(ans);
    }

    @Test
    public void test01() {
        System.out.println(calculate(" 3+5 / 2 "));
    }
}

// ops: +
// nus: 3 2




















