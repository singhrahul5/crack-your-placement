package com.rahul.crack_your_placement.arrays;

public class Q02_SortColors {
    public void sortColors(int[] nums) {

        int zero = 0;
        int two = nums.length - 1;
        int index = 0;
        while (index <= two) {
            if (nums[index] == 0) {
                nums[index] = nums[zero];
                nums[zero] = 0;
                zero++;
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[two];
                nums[two] = 2;
                two--;
            } else {
                index++;
            }
        }
    }
}
