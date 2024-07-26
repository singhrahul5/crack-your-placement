package com.rahul.crack_your_placement.string;

import java.util.*;

public class Q21_PrintAnagramsTogether {
    public List<List<String>> anagrams(String[] strs) {
        List<Integer> freq = new ArrayList<>(Collections.nCopies(26, 0));
        Map<List<Integer>, List<String>> map = new HashMap<>();
        int index;
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++)
                freq.set(index = str.charAt(i) - 'a', freq.get(index) + 1);

            map.computeIfAbsent(freq, (k) -> new ArrayList<>());

            map.get(freq).add(str);

            Collections.fill(freq, 0);
        }

        return new ArrayList<>(map.values());
    }
}
