package com.rahul.crack_your_placement.heap;

public class Q03_UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] result = new int[n+1];

        int two, three, five;
        two = three = five = 1;

        result[1] = 1;

        for(int i = 2; i <= n; i++) {
            int a = result[two]*2;
            int b = result[three]*3;
            int c = result[five]*5;

            result[i] = Math.min(a,Math.min(b,c));

            if(a == result[i])
                two++;
            if(b == result[i])
                three++;
            if(c==result[i])
                five++;
        }

        return result[n];
    }
}
