package com.rahul.crack_your_placement.tree;

public class Q18_CheckWhetherBSTContainsDeadEnd {
    public static boolean isDeadEnd(TreeNode root)
    {
        //Add your code here.
        return findDeadEnd(root, 1, 10001);
    }

    private static boolean findDeadEnd(TreeNode root, int left, int right) {
        if(root == null) return false;

        if(root.left == null && root.right == null) {
            return left == right;
        }

        return findDeadEnd(root.left, left, root.val-1 ) ||
                findDeadEnd( root.right, root.val+1, right);
    }
}
