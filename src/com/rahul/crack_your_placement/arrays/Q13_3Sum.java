package com.rahul.crack_your_placement.arrays;

import java.util.*;

public class Q13_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set = new HashSet<>();

        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {

                if(set.contains(-nums[i] - nums[j])) {
                    var list = Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]);
                    list.sort(Comparator.naturalOrder());
                    ans.add(list);
                }
            }
            set.add(nums[i]);

        }

        return new ArrayList<>(ans);
    }
}
