package com.rahul.crack_your_placement.string;

import java.util.Stack;

public class Q01_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (!stack.empty()
                    && (c == ')' && stack.peek() == '('
                    || c == '}' && stack.peek() == '{'
                    || c == ']' && stack.peek() == '[' )
            )
                stack.pop();
            else
                return false;
        }

        return stack.empty();
    }
}
