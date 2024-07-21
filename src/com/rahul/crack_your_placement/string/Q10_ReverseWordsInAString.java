package com.rahul.crack_your_placement.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q10_ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        List<String> wordsList = Arrays.asList(words);
        Collections.reverse(wordsList);

        return String.join(" ", wordsList);
    }
}
