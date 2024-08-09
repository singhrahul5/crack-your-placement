package com.rahul.crack_your_placement.tree;
import java.util.*;

public class Q40_SumOfDistancesInTree {
    int findSubTreeSize(
            List<List<Integer>> tree,
            int[] subtree,
            int node, int parent,
            int height
    ) {
        int result = height;
        subtree[node] = 1;
        for(int nbr: tree.get(node)) {
            if(nbr == parent) continue;

            result += findSubTreeSize(tree, subtree, nbr, node, height+1);
            subtree[node] += subtree[nbr];
        }
        return result;
    }

    void solve(
            List<List<Integer>> tree,
            int[] subtree,
            int[] ans,
            int n,
            int node, int parent
    ) {
        for(int nbr: tree.get(node)) {
            if(nbr == parent) continue;

            ans[nbr] = ans[node] - subtree[nbr]*2 + n;
            solve(tree, subtree, ans, n, nbr, node);
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] ans = new int[n];

        int[] subtree = new int[n];

        List<List<Integer>> tree = new ArrayList<>();

        for(int i = 0; i <n; i++)
            tree.add(new ArrayList<>());

        for(var edge: edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        ans[0] = findSubTreeSize(tree, subtree, 0, -1, 0);

        solve(tree, subtree, ans, n, 0, -1);

        return ans;
    }
}
