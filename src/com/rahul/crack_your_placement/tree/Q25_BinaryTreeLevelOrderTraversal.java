package com.rahul.crack_your_placement.tree;
import java.util.*;

public class Q25_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        if(root != null)
            q.add(root);


        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            while(size-- > 0) {
                var front = q.poll();
                level.add(front.val);

                if(front.left != null)
                    q.add(front.left);

                if(front.right != null)
                    q.add(front.right);
            }

            ans.add(level);
        }

        return ans;
    }
}
