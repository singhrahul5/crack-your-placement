package com.rahul.crack_your_placement.mathematical;

public class Q04_ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {

        StringBuilder ans = new StringBuilder();

        while(columnNumber > 0) {
            columnNumber --;
            int rem = columnNumber% 26;

            ans.append((char)('A' + rem));
            columnNumber /= 26;
        }

        return ans.reverse().toString();
    }
}
