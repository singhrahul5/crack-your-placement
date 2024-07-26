package com.rahul.crack_your_placement.arrays;

public class Q01_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        // to find cycle
        while (slow != fast) {
            //slow takes one step
            slow = nums[slow];
            //fast take two step
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            //now both take one step to find cycle entry point
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
