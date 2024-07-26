package com.rahul.crack_your_placement.mathematical;

public class Q02_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int aIdx, bIdx;

        aIdx = a.length() - 1;
        bIdx = b.length() - 1;

        int carry = 0;
        while (aIdx >= 0 && bIdx >= 0) {
            int total = a.charAt(aIdx--) + b.charAt(bIdx--) + carry - 2 * '0';
            carry = total / 2;
            ans.append(total % 2);
        }

        while (aIdx >= 0) {
            int total = a.charAt(aIdx--) + carry - '0';
            carry = total / 2;
            ans.append(total % 2);
        }

        while (bIdx >= 0) {
            int total = b.charAt(bIdx--) + carry - '0';
            carry = total / 2;
            ans.append(total % 2);
        }

        if (carry == 1) ans.append(carry);
        return ans.reverse().toString();
    }
}
