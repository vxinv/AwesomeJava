package org.vxinv.algorithm.递归.q104_二叉树的最大深度;

import org.vxinv.algorithm.树相关.util.TreeNode;

/**
 * 递归 o(n)
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
