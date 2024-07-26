package com.rahul.crack_your_placement.arrays;

public class Q05_MoveZeroes {
    public void moveZeroes(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }


    }
}
