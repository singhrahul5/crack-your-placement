package com.rahul.crack_your_placement.tree;

public class Q05_SymmetricTree {
    private boolean isEquals(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        else if( root1 == null || root2 == null)
            return false;

        return root1.val == root2.val
                && isEquals(root1.left, root2.right)
                && isEquals(root1.right, root2.left) ;
    }
    public boolean isSymmetric(TreeNode root) {
        return isEquals(root, root);
    }
}
