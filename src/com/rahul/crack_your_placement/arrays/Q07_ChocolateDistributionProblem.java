package com.rahul.crack_your_placement.arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class Q07_ChocolateDistributionProblem {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        a.sort(Comparator.naturalOrder());

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n - m; i++) {
            ans = Math.min(ans, a.get(i + m - 1) - a.get(i));
        }

        return ans;
    }
}
