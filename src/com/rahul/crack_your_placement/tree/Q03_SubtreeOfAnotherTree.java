package com.rahul.crack_your_placement.tree;

public class Q03_SubtreeOfAnotherTree {
    private boolean isEquals(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        else if( root1 == null || root2 == null)
            return false;

        return root1.val == root2.val
                && isEquals(root1.left, root2.left)
                && isEquals(root1.right, root2.right) ;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return subRoot == null;

        if(isEquals(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }
}
