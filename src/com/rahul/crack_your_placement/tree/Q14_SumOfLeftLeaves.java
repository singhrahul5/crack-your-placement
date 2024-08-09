package com.rahul.crack_your_placement.tree;

public class Q14_SumOfLeftLeaves {

    public Integer[] solve(TreeNode root) {
        if(root == null) {
            return new Integer[]{null, null};
        }

        if(root.left == null && root.right == null)
            return new Integer[]{null, root.val};

        Integer[] left = solve(root.left);
        Integer[] right = solve(root.right);

        int sum = 0;
        if(left[0] != null) {
            sum += left[0];
        } else if(left[1] != null){
            sum += left[1];
        }

        sum += (right[0] == null)? 0 : right[0];

        return new Integer[]{sum, null};
    }
    public int sumOfLeftLeaves(TreeNode root) {
        Integer ans;
        return (ans = solve(root)[0]) == null ? 0 : ans;
    }
}
