package com.rahul.crack_your_placement.tree;

import java.util.Arrays;

public class Q39_BinaryTreeMaximumPathSum {
    int solve(TreeNode root, int[] ans) {
        if(root == null)
            return -10000;

        int left = solve(root.left, ans);
        int right = solve(root.right, ans);

        ans[0] = Math.max(ans[0], root.val +
                Arrays.stream(new int[]{0, left, right, left + right})
                        .max().getAsInt());

        return root.val +
                Arrays.stream(new int[]{0, left, right})
                        .max().getAsInt();
    }
    public int maxPathSum(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};
        solve(root, ans);
        return ans[0];
    }
}
