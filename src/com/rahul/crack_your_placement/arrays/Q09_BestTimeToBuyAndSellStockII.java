package com.rahul.crack_your_placement.arrays;

public class Q09_BestTimeToBuyAndSellStockII {
    int rec(int index, int buy, int[] prices) {
        if (index == prices.length) return 0;

        int ans = rec(index + 1, buy, prices);
        if (buy == 1) {
            ans = Math.max(ans, -prices[index] + rec(index + 1, 0, prices));
        } else {
            ans = Math.max(ans, prices[index] + rec(index + 1, 1, prices));
        }

        return ans;
    }

    int so(int[] prices) {
        int n = prices.length;

        int buy, sell, nbuy, nsell;
        nbuy = nsell = 0;

        for (int index = n - 1; index >= 0; index--) {

            buy = Math.max(nbuy, -prices[index] + nsell);
            sell = Math.max(nsell, prices[index] + nbuy);

            nbuy = buy;
            nsell = sell;
        }

        return nbuy;
    }

    public int maxProfit(int[] prices) {
        // return rec(0, 1, prices);
        return so(prices);
    }
}
