package com.rahul.crack_your_placement.arrays;

public class Q18_WordSearch {
    boolean find(int index, int row, int col, String word,boolean[][] vis, char[][] board, int n, int m) {
        if(index == word.length()) return true;

        if(row < 0 || row >= n || col < 0 || col >= m) return false;

        if(vis[row][col]) return false;


        if (word.charAt(index) == board[row][col]) {
            vis[row][col] = true;
            boolean ans = find(index+1, row-1, col, word, vis, board, n, m)
                    || find(index+1, row+1, col, word, vis, board, n, m)
                    || find(index+1, row, col-1, word, vis, board, n, m)
                    || find(index+1, row, col+1, word, vis, board, n, m);

            vis[row][col] = false;
            return ans;
        }

        return false;

    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col ++) {
                if(find(0, row, col, word, vis, board, n, m))
                    return true;
            }
        }

        return false;
    }
}
