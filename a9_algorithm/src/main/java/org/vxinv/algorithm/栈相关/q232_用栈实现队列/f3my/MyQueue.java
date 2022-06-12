package org.vxinv.algorithm.栈相关.q232_用栈实现队列.f3my;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 */
class MyQueue {
    Stack<Integer> real = new Stack<>();
    Stack<Integer> help = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        real.push(x);
    }

    public int pop() {
        transfer(real,help);
        int pop = help.pop();
        transfer(help,real);
        return pop;
    }

    public int peek() {
        transfer(real,help);
        int pop = help.peek();
        transfer(help,real);
        return pop;
    }

    public boolean empty() {
        return real.empty();
    }

    public void transfer(Stack<Integer> origin, Stack<Integer> traget){
        while (!origin.empty()){
            traget.push(origin.pop());
        }
    }

    @Test
    public void test01(){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
