package com.rahul.crack_your_placement.tree;

public class Q38_BinaryTreeToDLL {
    TreeNode solve(TreeNode root) {
        if(root == null) return null;
        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);

        TreeNode start, end, s, e;
        start = root;
        end = root;


        if(left != null) {
            s = left;
            e = left.left;

            e.right = start;
            start.left = e;

            start = s;
        }

        if(right != null) {
            s = right;
            e = right.left;

            end.right = s;
            s.left = end;

            end = e;
        }

        start.left = end;
        end.right = start;
        return start;
    }
    TreeNode bToDLL(TreeNode root)
    {
        //  Your code here	
        TreeNode start = solve(root);

        TreeNode end = start.left;

        start.left = end.right = null;

        return start;
    }
}
