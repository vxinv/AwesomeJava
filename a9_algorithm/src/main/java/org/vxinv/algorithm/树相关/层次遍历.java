package org.vxinv.algorithm.树相关;


import org.junit.jupiter.api.Test;
import org.vxinv.algorithm.树相关.util.TreeNode;
import org.vxinv.algorithm.树相关.util.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 层次遍历 {
    /*
     *            3
     *         /    \
     *       9       20
     *              /  \
     *             15   7
     * */

    /**
     * 基于 BFS 实现二叉树层次遍历。关键在于使用一个队列存储
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                list.add(node.val);
            }
            result.add(list);
        }
        return result;
    }

    @Test
    public void test01(){
        TreeNode tree = TreeUtils.asTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> resultList = levelOrder(tree);
        System.out.println(resultList);
    }
}
