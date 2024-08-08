package com.rahul.crack_your_placement.tree;

import java.util.ArrayList;
import java.util.List;

public class Q09_BinaryTreePaths {
    private void solve(TreeNode root, List<Integer> path, List<String> ans) {
        if(root == null) return;

        path.add(root.val);
        if(root.left == null && root.right == null){
            ans.add(String.join("->", path.stream().map(String::valueOf).toList()));
        } else {
            solve(root.left, path, ans);
            solve(root.right, path, ans);
        }
        path.remove(path.size() - 1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        solve(root, new ArrayList<>(), ans);

        return ans;
    }
}
