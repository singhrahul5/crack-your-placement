package com.rahul.crack_your_placement.tree;

public class Q13_MinimumAbsoluteDifferenceInBST {
    int[] solve(TreeNode root) {
        if(root == null)
            return null;

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int[] ans ;
        if(left != null && right != null) {
            int minDiff = Math.min(root.val - left[1], right[0] - root.val);
            minDiff = Math.min(minDiff, Math.min(right[2], left[2]));
            ans = new int[]{left[0], right[1], minDiff};
        } else if(left != null) {
            int minDiff = Math.min(root.val - left[1], left[2]);
            ans = new int[]{left[0], root.val, minDiff};
        } else if(right != null) {
            int minDiff = Math.min(right[0] - root.val, right[2]);
            ans = new int[]{root.val, right[1], minDiff};
        } else {
            ans = new int[]{root.val, root.val, Integer.MAX_VALUE};
        }
        return ans;
    }
    public int getMinimumDifference(TreeNode root) {
        return solve(root)[2];
    }
}
