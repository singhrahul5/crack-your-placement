package com.rahul.crack_your_placement.arrays;

public class Q15_MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {

        int[] right = new int[k + 1];
        int n = cardPoints.length;
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += cardPoints[n - i];
            right[i] = sum;
        }

        int ans = right[k];

        sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
            ans = Math.max(ans, sum + right[k - i - 1]);
        }

        return ans;
    }
}
