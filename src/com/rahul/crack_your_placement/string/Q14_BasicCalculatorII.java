package com.rahul.crack_your_placement.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q14_BasicCalculatorII {
    boolean isGreater(String op1, String op2) {
        return op1.equals("/") && op2.equals("+")
                || op1.equals("*") && op2.equals("+")
                || op1.equals("/") && op2.equals("-")
                || op1.equals("*") && op2.equals("-") ;
    }
    boolean isOperator(String op) {
        return op.equals("/") || op.equals("-")
                || op.equals("*") || op.equals("+");
    }

    long calc(long operand1, long operand2, String operator) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            default -> operand1 / operand2;
        };
    }

    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        int len = s.length();
        int index = 0;
        List<String> infix = new ArrayList<>();
        while(index < len) {
            int start = index;

            while(index < len && !String.valueOf(s.charAt(index)).matches("[+\\-*/]"))
                index ++;

            infix.add(s.substring(start, index));
            if(index < len)
                infix.add(s.substring(index, index+1));
            index++;
        }

        Stack<String> stack = new Stack<>();

        List<String> postfix = new ArrayList<>();
        for(String str: infix) {
            if(isOperator(str)) {
                while(!stack.empty() && !isGreater(str, stack.peek()))
                    postfix.add(stack.pop());

                stack.push(str);
            } else
                postfix.add(str);

        }
        while(!stack.isEmpty())
            postfix.add(stack.pop());




        //evaluate

        Stack<Long> stt = new Stack<>();
        for(String str: postfix) {
            if(isOperator(str)) {
                long opr2 = stt.pop();
                long opr1 = stt.pop();

                long ans = calc(opr1, opr2, str);
                stt.push(ans);
            } else
                stt.push(Long.valueOf(str));

        }


        return stt.pop().intValue();
    }
}
