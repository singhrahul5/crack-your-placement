package com.rahul.crack_your_placement.arrays;

import java.util.ArrayList;
import java.util.List;

public class Q17_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
             top <= bottom && left <= right;
             top++, bottom--, left++, right--
        ) {
            //top row of current rectangle
            for (int trav = left; trav <= right; trav++)
                ans.add(matrix[top][trav]);

            //right col of current rectangle
            for (int trav = top + 1; trav < bottom; trav++)
                ans.add(matrix[trav][right]);

            //bottom row of current rectangle
            if (top != bottom)
                for (int trav = right; trav >= left; trav--)
                    ans.add(matrix[bottom][trav]);

            //left row of current rectangle
            if (left != right)
                for (int trav = bottom - 1; trav > top; trav--)
                    ans.add(matrix[trav][left]);
        }

        return ans;
    }
}
