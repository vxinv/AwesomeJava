package org.vxinv.algorithm.栈相关.q227_基本计算器二.f2;

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
        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();
        Stack<Integer> nums = new Stack<>();
        nums.push(0);
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
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
            } else if (isNumber(c)) {
                int u = 0;
                int j = i;
                while (j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] - '0');
                nums.push(u);
                i = j - 1;
            } else {
                if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                    System.out.println("line use");
                    nums.push(0);
                }
                // 完成当前括号运算
                while (!ops.isEmpty() && ops.peek() != '(') {
                    char prev = ops.peek();
                    if (map.get(prev) >= map.get(c)) {
                        calc(nums, ops);
                    } else {
                        break;
                    }
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty() && ops.peek() != '(') calc(nums, ops);
        return nums.peek();
    }

    void calc(Stack<Integer> nums, Stack<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '/') {
            ans = a / b;
        } else if (op == '^') {
            ans = (int) Math.pow(a, b);
        } else if (op == '%') {
            ans = a % b;
        }
        nums.push(ans);
    }

    boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    @Test
    public void test01() {
        System.out.println(calculate(" 3+5 / 2 "));
    }
}






















