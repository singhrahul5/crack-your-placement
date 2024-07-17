package com.rahul.crack_your_placement.arrays;

public class Q03_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        int k = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[k])
                nums[++k] = nums[i];

        }
        return k+1;
    }
}
