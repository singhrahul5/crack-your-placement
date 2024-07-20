package com.rahul.crack_your_placement.string;

public class Q04_ValidPalindromeII {
    boolean isPalindrome(String s, int removedIndex) {
        int left = 0;
        int right = s.length() -1;

        while(left < right) {
            if(left == removedIndex) {
                left ++;
                continue;
            }
            if(right == removedIndex) {
                right --;
                continue;
            }

            if(s.charAt(left) != s.charAt(right))
                return false;

            right --;
            left ++;
        }

        return true;
    }
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;

        int firstMismatch = -1;
        int lastMismatch = -1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                firstMismatch = left;
                lastMismatch = right;
                break;
            }

            right --;
            left ++;
        }

        return isPalindrome(s, firstMismatch) || isPalindrome(s, lastMismatch);
    }
}
