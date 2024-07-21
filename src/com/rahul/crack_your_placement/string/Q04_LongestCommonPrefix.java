package com.rahul.crack_your_placement.string;

public class Q04_LongestCommonPrefix {
    static class Trie {
        Trie[] childs = new Trie[26];
        int count = 0;
        boolean terminal = false;
    }
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();

        for(String s: strs) {
            Trie trav = root;
            for(int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';

                if(trav.childs[index] == null) {
                    trav.count ++;
                    trav.childs[index] = new Trie();
                }

                trav = trav.childs[index];
            }
            trav.terminal = true;
        }

        Trie trav = root;

        String first = strs[0];
        int index = 0;
        for(; index < first.length(); index ++) {
            if(trav.count != 1 || trav.terminal) break;

            trav = trav.childs[first.charAt(index) - 'a'];
        }

        return first.substring(0, index);
    }
}
