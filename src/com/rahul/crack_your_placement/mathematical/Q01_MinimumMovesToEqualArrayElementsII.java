package com.rahul.crack_your_placement.mathematical;

import java.util.Arrays;

public class Q01_MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int n = nums.length;

        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            if (i < mid)
                left += nums[i];
            else
                right += nums[i];
        }

        return right - left - (n % 2 == 1 ? nums[mid] : 0);

    }
}
