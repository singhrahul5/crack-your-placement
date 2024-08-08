package com.rahul.crack_your_placement.tree;

public class Q08_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
