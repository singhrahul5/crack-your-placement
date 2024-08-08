package com.rahul.crack_your_placement.tree;

public class Q11_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        var left = lowestCommonAncestor(root.left, p, q);
        var right = lowestCommonAncestor(root.right, p, q);

        if(
                (left != null && right != null) ||
                        (root == p || root == q)
        ) {
            return root;
        } else {
            return (left != null) ? left : right;
        }
    }
}
