package com.rahul.crack_your_placement.tree;

public class Q02_InvertBinaryTree {
    private void invert(TreeNode root) {
        if(root == null) return;

        invert(root.left);
        invert(root.right);

        var temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}
