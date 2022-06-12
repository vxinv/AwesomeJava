package org.vxinv.algorithm.栈相关.q155_最小栈;

import java.util.Stack;

/**
 * 不使用辅助栈，每次push两个元素
 * 栈顶是最大元素
 */
public class MinStack {

    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int tmp = stack.peek();
            stack.push(x);
            stack.push(Math.min(tmp, x));
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }
}
