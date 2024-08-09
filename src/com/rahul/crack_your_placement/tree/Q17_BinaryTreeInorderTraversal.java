package com.rahul.crack_your_placement.tree;

import java.util.*;

public class Q17_BinaryTreeInorderTraversal {
    void trav(TreeNode root, List<Integer> ans) {
        if(root == null) return;

        trav(root.left, ans) ;
        ans.add(root.val);
        trav(root.right, ans);

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        var ans = new ArrayList<Integer>();

        trav(root, ans);
        return ans;
    }
}
