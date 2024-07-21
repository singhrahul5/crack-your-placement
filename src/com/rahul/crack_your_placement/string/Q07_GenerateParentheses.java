package com.rahul.crack_your_placement.string;

import java.util.ArrayList;
import java.util.List;

public class Q07_GenerateParentheses {
    void solve(int open, int close, StringBuilder sb, List<String> ans) {
        if(open == 0 && close == 0) {
            ans.add(sb.toString());
            return;
        }

        if(open > 0) {
            sb.append('(');
            solve(open -1, close, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(open < close) {
            sb.append(')');
            solve(open, close-1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        solve(n, n, new StringBuilder(), ans);

        return ans;
    }
}
