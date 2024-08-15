package com.rahul.crack_your_placement.tree;

public class Q23_ValidateBinarySearchTree {
    private boolean solve(TreeNode root, long left, long right) {
        if(root == null) return true;

        return root.val >= left && root.val <= right &&
                solve(root.left, left, (long)root.val - 1) &&
                solve(root.right, (long)root.val + 1 , right);
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
