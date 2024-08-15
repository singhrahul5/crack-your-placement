package com.rahul.crack_your_placement.tree;

import java.util.ArrayList;
import java.util.List;

public class Q21_UniqueBinarySearchTreesII {
    private List<TreeNode> solve(int left, int right) {
        List<TreeNode> ans = new ArrayList<>();

        if(left > right) {
            ans.add(null);
            return ans;
        }

        for(int root = left; root <= right; root ++) {
            var leftTree = solve(left, root-1);
            var rightTree = solve(root+1, right);

            for(var leftNode: leftTree)
                for(var rightNode: rightTree)
                    ans.add(new TreeNode(root, leftNode, rightNode));
        }

        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }
}
