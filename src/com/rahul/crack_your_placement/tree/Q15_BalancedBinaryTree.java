package com.rahul.crack_your_placement.tree;

public class Q15_BalancedBinaryTree {
    int[] check (TreeNode root) {
        if(root == null ) return new int[]{0, 1};

        int[] left = check(root.left);
        int[] right = check(root.right);

        return new int[]{
                1+ Math.max(left[0], right[0]),
                left[1] & right[1] & (Math.abs(left[0] - right[0]) <= 1 ? 1 : 0)
        };
    }
    public boolean isBalanced(TreeNode root) {
        return check(root)[1] == 1;
    }
}
