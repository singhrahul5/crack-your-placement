package com.rahul.crack_your_placement.tree;

public class Q10_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null)
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return (p == null && q == null);
    }
}
