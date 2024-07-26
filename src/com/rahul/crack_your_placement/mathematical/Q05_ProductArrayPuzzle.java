package com.rahul.crack_your_placement.mathematical;

import java.util.Arrays;

public class Q05_ProductArrayPuzzle {
    public static long[] productExceptSelf(int[] nums, int n) {
        long[] ans = new long[n];
        Arrays.fill(ans, 1);

        long prefixMul = 1;
        long postfixMul = 1;

        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            ans[i] *= prefixMul;
            prefixMul *= nums[i];

            ans[j] *= postfixMul;
            postfixMul *= nums[j];
        }

        return ans;
    }
}
