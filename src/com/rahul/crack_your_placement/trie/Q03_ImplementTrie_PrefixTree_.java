package com.rahul.crack_your_placement.trie;

public class Q03_ImplementTrie_PrefixTree_ {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    static class Trie {
        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean terminal = false;;
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            var trav = root;
            for(int i = 0; i <word.length(); i++) {
                int childIndex = word.charAt(i) - 'a';

                if(trav.children[childIndex] == null)
                    trav.children[childIndex] = new TrieNode();

                trav = trav.children[childIndex];
            }

            trav.terminal = true;
        }

        public boolean search(String word) {
            return searchUtil(0, word, root, false);
        }

        public boolean searchUtil(int index, String word, TrieNode trav, boolean prefix) {
            if(trav == null)
                return false;

            if(index == word.length())
                return prefix || trav.terminal;


            if(word.charAt(index) != '.')
                return searchUtil(index + 1, word, trav.children[word.charAt(index) - 'a'], prefix);


            for(var child: trav.children){
                if(searchUtil(index + 1, word, child, prefix))
                    return true;

            }

            return false;
        }

        public boolean startsWith(String prefix) {
            return searchUtil(0, prefix, root, true);
        }
    }


}
