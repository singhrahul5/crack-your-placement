package com.rahul.crack_your_placement.arrays;

public class Q12_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left, right, area, ans;
        left = 0;
        right = height.length - 1;
        ans = 0;

        while(left < right) {
            area = Math.min(height[left] , height[right]) * (right - left);
            ans = Math.max(ans, area);

            if(height[left] < height[right])
                left ++;
            else
                right --;
        }

        return ans;
    }
}
