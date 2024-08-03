package com.rahul.crack_your_placement.heap;

import java.util.PriorityQueue;

public class Q02_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        var heap = new PriorityQueue<Integer>();

        for(int num: nums) {
            if(heap.size() < k)
                heap.add(num);
            else if(heap.peek() < num) {
                heap.poll();
                heap.add(num);
            }
        }

        return heap.peek();
    }
}
