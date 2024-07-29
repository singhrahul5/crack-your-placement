package com.rahul.crack_your_placement.heap;

import java.util.*;
import java.util.PriorityQueue;

public class Q01_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> heap
                = new PriorityQueue<>(
                Comparator.<Pair<Integer, Integer>>comparingInt(Pair::value).reversed());

        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(var entry: map.entrySet()) {
            heap.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        int index = 0;

        while(index < k) {
            result[index++] = heap.poll().key();
        }
        return result;
    }
}
