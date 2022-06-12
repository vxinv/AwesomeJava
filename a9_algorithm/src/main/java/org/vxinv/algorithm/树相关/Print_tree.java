package org.vxinv.algorithm.树相关;

public class Print_tree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        // 打印函数，先传入头结点
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    // head表示当前传入节点
    // height当前节点所在的高度
    // to表示当前节点的指向信息
    // len表示打印当前值填充到多少位当成一个完整的值
    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        // 递归右树，右树向下指
        printInOrder(head.right, height + 1, "v", len);
        /**
         * 打印自己的值
         * val 表示值内容
         **/
        String val = to + head.value + to;
        int lenM = val.length();
        // 按照len算该值左侧需要填充多少空格
        int lenL = (len - lenM) / 2;
        // 按照len算该值右侧需要填充多少空格
        int lenR = len - lenM - lenL;
        // 实际值加上左右占位，表示每个值包括占位之后大小
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        // 递归左树，左树向上指
        printInOrder(head.left, height + 1, "^", len);
    }

    // 根据height*len补空格
    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(-222222222);
        head.right = new Node(3);
        head.left.left = new Node(Integer.MIN_VALUE);
        head.right.left = new Node(55555555);
        head.right.right = new Node(66);
        head.left.left.right = new Node(777);
        printTree(head);

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        printTree(head);

        head = new Node(1);
        head.left = new Node(1);
        head.right = new Node(1);
        head.left.left = new Node(1);
        head.right.left = new Node(1);
        head.right.right = new Node(1);
        head.left.left.right = new Node(1);
        printTree(head);

    }
}
