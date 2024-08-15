package com.rahul.crack_your_placement.tree;

import java.util.*;

public class Q22_AllNodesDistanceKInBinaryTree {

    void mapChildToParent(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (root == null)
            return;

        parentMap.put(root, parent);

        mapChildToParent(root.left, root, parentMap);
        mapChildToParent(root.right, root, parentMap);
    }

    void solve(TreeNode root, Map<TreeNode, TreeNode> parentMap, int k, Set<TreeNode> vis, List<Integer> ans) {
        if (root == null || vis.contains(root))
            return;

        vis.add(root);

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        solve(root.left, parentMap, k - 1, vis, ans);
        solve(root.right, parentMap, k - 1, vis, ans);
        solve(parentMap.get(root), parentMap, k - 1, vis, ans);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        mapChildToParent(root, null, parentMap);

        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> vis = new HashSet<>();

        solve(target, parentMap, k, vis, ans);

        return ans;
    }
}
