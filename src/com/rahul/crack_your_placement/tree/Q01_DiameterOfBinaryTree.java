package com.rahul.crack_your_placement.tree;

public class Q01_DiameterOfBinaryTree {
    int max = 0;

    int height(TreeNode root) {
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        max = Math.max(max,left + right);

        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);

        return max;
    }
}
