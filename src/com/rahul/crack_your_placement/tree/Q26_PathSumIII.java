package com.rahul.crack_your_placement.tree;

import java.util.HashMap;
import java.util.Map;

public class Q26_PathSumIII {
    private int solve(TreeNode root, long sum, int targetSum, Map<Long, Integer> prefix) {
        if (root == null) return 0;

        long totalSum = sum + root.val;

        int ans = prefix.getOrDefault(totalSum - targetSum, 0);

        prefix.put(totalSum, prefix.getOrDefault(totalSum, 0) + 1);
        ans += solve(root.left, totalSum, targetSum, prefix) +
                solve(root.right, totalSum, targetSum, prefix);

        prefix.put(totalSum, prefix.getOrDefault(totalSum, 0) - 1);

        return ans;
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);

        return solve(root, 0, targetSum, prefix);
    }
}
