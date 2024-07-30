package com.rahul.crack_your_placement.tree;

public class Q04_RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        else if (root.val > high)
            return rangeSumBST(root.left, low, high);

        return root.val + rangeSumBST(root.right, low, high)
                + rangeSumBST(root.left, low, high);
    }
}
