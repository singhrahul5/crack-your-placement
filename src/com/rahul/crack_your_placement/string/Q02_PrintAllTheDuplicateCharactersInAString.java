package com.rahul.crack_your_placement.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q02_PrintAllTheDuplicateCharactersInAString {

    static void printAllTheDuplicateChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.compute(c, (key, val) -> val == null ? 1 : val + 1);
        }

        for (var entry : count.entrySet()) {
            System.out.printf("%c, count= %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        printAllTheDuplicateChar(s);
    }
}
