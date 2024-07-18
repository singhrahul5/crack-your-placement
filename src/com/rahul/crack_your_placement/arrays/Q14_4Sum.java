package com.rahul.crack_your_placement.arrays;

import java.util.*;

public class Q14_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<Long> set = new HashSet<>();
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();

        for(int i = 0; i < n; i ++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    long need = (long)target-nums[i] - nums[j]- nums[k];

                    if(set.contains(need)) {
                        var list = Arrays.asList(nums[i], nums[j], nums[k], (int)need);
                        list.sort(Comparator.naturalOrder());
                        ans.add(list);
                    }
                }
            }

            set.add((long) nums[i]);
        }

        return new ArrayList<>(ans);
    }
}
