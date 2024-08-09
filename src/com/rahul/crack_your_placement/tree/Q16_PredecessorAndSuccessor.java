package com.rahul.crack_your_placement.tree;

public class Q16_PredecessorAndSuccessor {
    public static void findPreSuc(TreeNode root, TreeNode[] pre, TreeNode[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key

        if(root == null) return;

        if(root.val < key) {
            if(pre[0] != null)
                pre[0] = (pre[0].val < root.val) ? root: pre[0];
            else
                pre[0] = root;
        }

        if(root.val > key) {
            if(suc[0] != null)
                suc[0] = (suc[0].val > root.val) ? root: suc[0];
            else
                suc[0] = root;
        }

        findPreSuc(root.left, pre, suc, key);
        findPreSuc(root.right, pre, suc, key);
    }
}
