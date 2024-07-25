package com.rahul.crack_your_placement.sorting_and_searching;

import java.util.Arrays;

public class Q03_FindPairGivenDifference {
    public int findPair(int n, int x, int[] arr) {
        // code here
        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            int left = i+1;
            int right = n-1;

            int target = x + arr[i];

            while(left <= right) {
                int mid = (left+right)/2;

                if(target > arr[mid]) {
                    left = mid + 1;
                } else if(target < arr[mid]) {
                    right = mid - 1;
                } else {
                    return 1;
                }
            }
        }

        return -1;
    }
}
