package com.rahul.crack_your_placement.tree;

public class Q07_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 != null && root2 != null)
            return new TreeNode(
                    root1.val + root2.val,
                    mergeTrees(root1.left, root2.left),
                    mergeTrees(root1.right, root2.right)
            );
        else if(root1 != null)
            return new TreeNode(
                    root1.val ,
                    mergeTrees(root1.left, null),
                    mergeTrees(root1.right, null)
            );
        else if(root2 != null)
            return new TreeNode(
                    root2.val,
                    mergeTrees(null, root2.left),
                    mergeTrees(null, root2.right)
            );
        else
            return null;
    }
}
