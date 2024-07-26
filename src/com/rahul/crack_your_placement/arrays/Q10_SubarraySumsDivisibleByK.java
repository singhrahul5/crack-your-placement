package com.rahul.crack_your_placement.arrays;

public class Q10_SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefixRem = new int[k];
        prefixRem[0] = 1;

        int rem = 0;
        int ans = 0;
        for (int num : nums) {
            rem = Math.floorMod(num + rem, k);

            ans += prefixRem[rem];
            prefixRem[rem]++;
        }
        return ans;
    }
}
