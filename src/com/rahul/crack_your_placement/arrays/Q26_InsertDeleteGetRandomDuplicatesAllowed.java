package com.rahul.crack_your_placement.arrays;

import java.util.*;

public class Q26_InsertDeleteGetRandomDuplicatesAllowed {
    static class RandomizedCollection {

        Map<Integer, Set<Integer>> map;
        List<Integer> list;
        Random rnd;

        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rnd = new Random();
        }

        public boolean insert(int val) {
            list.add(val);
            int index = list.size() - 1;

            boolean result = !map.containsKey(val);
            map.computeIfAbsent(val, (k) -> new HashSet<>()).add(index);
            return result;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                Set<Integer> set = map.get(val);

                int indexToRemove = set.iterator().next();
                int lastIndex = list.size() - 1;
                int lastVal = list.get(lastIndex);
                list.set(indexToRemove, lastVal);
                list.remove(lastIndex);
                set.remove(indexToRemove);


                var set2 = map.get(lastVal);
                set2.add(indexToRemove);
                set2.remove(lastIndex);

                if (set.isEmpty())
                    map.remove(val);
                return true;
            }

            return false;
        }

        public int getRandom() {
            return list.get(rnd.nextInt(list.size()));
        }
    }
}
