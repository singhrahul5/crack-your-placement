package com.rahul.crack_your_placement.arrays;

import java.util.ArrayList;
import java.util.List;

public class Q11_FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] < 0)
                ans.add(index + 1);

            nums[index] *= -1;
        }

        return ans;
    }
}
