package com.rahul.crack_your_placement.arrays;

public class Q22_ReversePairs {
    int findEleCountGreaterThenTarget(int start, int end, long target, int[] nums) {
        int last = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return last - end;
    }

    int findRevPairCount(int start, int mid, int end, int[] nums) {
        int revPairs = 0;
        for (int i = mid + 1; i <= end; i++) {
            revPairs += findEleCountGreaterThenTarget(start, mid, nums[i] * 2L, nums);
        }

        return revPairs;
    }

    int mergeSortAndFindRevPair(int start, int end, int[] nums) {
        if (start == end) return 0;

        int mid = (start + end) / 2;

        int revPairs = mergeSortAndFindRevPair(start, mid, nums);
        revPairs += mergeSortAndFindRevPair(mid + 1, end, nums);
        // System.out.print(start + " " + mid + " " + end + "= ");
        // System.out.println(findRevPairCount(start, mid, end, nums));
        // System.out.println(Arrays.toString(nums));
        revPairs += findRevPairCount(start, mid, end, nums);

        merge(start, mid, end, nums);

        return revPairs;
    }

    void merge(int start, int mid, int end, int[] nums) {

        int first = start;
        int second = mid + 1;
        int index = 0;
        int[] newNums = new int[end - start + 1];

        while (first <= mid && second <= end) {
            if (nums[first] <= nums[second])
                newNums[index++] = nums[first++];
            else
                newNums[index++] = nums[second++];
        }

        while (first <= mid) {
            newNums[index++] = nums[first++];
        }
        while (second <= end) {
            newNums[index++] = nums[second++];
        }

        for (int i = start, j = 0; i <= end; i++, j++) {
            nums[i] = newNums[j];
        }
    }

    public int reversePairs(int[] nums) {

        // System.out.println(findRevPairCount(0,2, 4, new int[]{1, 2, 3, 1,3}));
        return mergeSortAndFindRevPair(0, nums.length - 1, nums);
    }
}
