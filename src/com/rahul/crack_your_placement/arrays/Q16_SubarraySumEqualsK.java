package com.rahul.crack_your_placement.arrays;

import java.util.HashMap;
import java.util.Map;

public class Q16_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            ans += prefixSum.getOrDefault(sum - k, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
