package org.vxinv.algorithm.树相关;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.vxinv.algorithm.树相关.util.TreeUtils;

import java.util.ArrayList;

public class 二叉树最大高度104 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    static Node head = null;


    /*
     * leetcode 104 二叉树最大深度
        3
       / \
      9  20
        /  \
       15   37
     */
    @BeforeAll
    public static void maxDepthMain() {
        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.left.right.right = new Node(3);

        /*
                        1
                2                  3
            4      5            6      7
                       3
         */
    }

    @Test
    public void testMaxDepth() {
        System.out.println(maxDepth(head));
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int v = node.value;
            int ml = maxDepth(node.left);
            int mr = maxDepth(node.right);
            int max = Math.max(ml, mr);
            return max + 1;
        }
    }

    /*
     * leetcode  98  验证二叉搜索树
        输入:
            5
           / \
          1   7
             / \
             3   9
        输出: false
        解释: 输入为: [5,1,4,null,null,3,6]
     */

    /*
                6
        4               8
    1       5
     */
    public static void isValidBST2(Node node) {
        Node head = new Node(6);
        head.left = new Node(4);
        head.right = new Node(8);
        head.left.left = new Node(1);
        head.left.right = new Node(5);

        System.out.println(recurse(head, null, null));
    }

    /*
        递归证明
     */
    public static boolean recurse(Node node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.value;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        // 左节点递归 使用该点 的val作为左节点的右节点的最大值
        if (!recurse(node.left, lower, val)) return false;
        if (!recurse(node.right, val, upper)) return false;
        return true;
    }

    /**
     * 中序遍历
     */
    public static boolean isValidBST3() {
        Node head = new Node(6);
        head.left = new Node(4);
        head.right = new Node(8);
        head.left.left = new Node(1);
        head.left.right = new Node(5);
        recurse1(head);
        for (int i = 0; i < integers.size() - 1; i++) {
            if (integers.get(i) >= integers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static ArrayList<Integer> integers = new ArrayList<>();

    public static void recurse1(Node node) {
        if (node == null) {
            return;
        }
        recurse1(node.left);
        System.out.println(node.value);
        // 将中序遍历的结果存入List
        integers.add(node.value);
        recurse1(node.right);
    }

    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }


}
