package org.vxinv.algorithm.树相关;

import org.junit.jupiter.api.Test;

/**
 * 前序 中序 后序 遍历
 */
public class 前序_中序_后序_遍历 {
    public static int level = 0;
    static int maxLevel = 0;
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void f(Node head) {
        if (head == null) {
            return;
        }
        // 1 此处打印等于先序
        f(head.left);
        // 2 此处打印等于中序
        f(head.right);
        // 3 此处打印等于后序
    }

    // 先序打印所有节点
    public static void pre(Node head) {
        System.out.println(head.value);
        if (head == null) {
            return;
        }
        // 打印头
        System.out.println(head.value);
        // 递归打印左子树
        pre(head.left);
        // 递归打印右子树
        pre(head.right);
    }


    // 中序遍历
    public static void in(Node head) {
        String msg = "null";
        if (head != null){
            msg = String.valueOf(head.value);
        }
        System.out.println(msg);
        if (head == null) {
            return;
        }
        if (level > maxLevel) maxLevel = level;
        in(head.left);
        System.out.println("print:" + head.value);
        in(head.right);
    }

    // 后序遍历
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

    public static void fanx(Node head){
        if (head == null) {
            return;
        }
        fanx(head.right);
        fanx(head.left);
        System.out.println(head.value);
    }

    /**
                4
            2        6
         1    3   5    8
                      7  9
     */
    public Node createTree(){
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(8);
        head.right.right.left = new Node(7);
        head.right.right.right = new Node(9);
        return head;
    }

    /**
     * 中序遍历
     */
    @Test
    public void test1(){

        Node tree = createTree();
        in(tree);
        System.out.println("maxLevel: "+ maxLevel);
    }
}
