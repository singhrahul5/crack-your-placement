package com.rahul.crack_your_placement.tree;

public class Q06_ConvertSortedArrayToBinarySearchTree {
    TreeNode buildBst(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = (left + right)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBst(nums, left, mid - 1);
        root.right = buildBst(nums, mid+1, right);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBst(nums, 0, nums.length-1);
    }
}
