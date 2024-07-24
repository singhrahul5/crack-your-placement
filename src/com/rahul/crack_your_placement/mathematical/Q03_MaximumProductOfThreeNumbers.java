package com.rahul.crack_your_placement.mathematical;

public class Q03_MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int one, two, three;
        one = two = three = Integer.MIN_VALUE;

        int nOne, nTwo;
        nOne = nTwo = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num >= one) {
                three = two;
                two = one;
                one = num;
            } else if (num >= two) {
                three = two;
                two = num;
            } else if (num > three) {
                three = num;
            }

            if (num <= nOne) {
                nTwo = nOne;
                nOne = num;
            } else if (num <= nTwo) {
                nTwo = num;
            }
        }

        return Math.max(one * two * three, nOne * nTwo * one);
    }
}
