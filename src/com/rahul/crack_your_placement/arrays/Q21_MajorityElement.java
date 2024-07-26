package com.rahul.crack_your_placement.arrays;

public class Q21_MajorityElement {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ele) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                ele = nums[i];
                count = 1;
            }
        }
        return ele;
    }
}
