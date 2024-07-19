package com.rahul.crack_your_placement.arrays;

public class Q20_JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for(int i = n-2; i >= 0; i--) {
            int maxIndex = nums[i]+i ;
            if(maxIndex >= n-1) {
                dp[i] = true;
            } else {
                for(int j = i+1; j <= maxIndex; j++) {
                    if(dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
