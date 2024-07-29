package com.rahul.crack_your_placement.trie;

public class Q01_DesignAddAndSearchWordsDataStructure {
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    static class WordDictionary {
        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean terminal = false;;
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
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
            return searchUtil(0, word, root);
        }

        public boolean searchUtil(int index, String word, TrieNode trav) {
            if(trav == null)
                return false;

            if(index == word.length())
                return trav.terminal;


            if(word.charAt(index) != '.')
                return searchUtil(index + 1, word, trav.children[word.charAt(index) - 'a']);


            for(var child: trav.children){
                if(searchUtil(index + 1, word, child))
                    return true;

            }

            return false;
        }
    }


}
