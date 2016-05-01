public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int l = prices.length;
        int[] buy = new int[l];
        int[] sell = new int[l];
        buy[0] = - prices[0];
        sell[0] = 0;
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(0, prices[1]+buy[0]);
        
        for (int i = 2; i < l; i++) {
            int delta = prices[i] - prices[i-1];
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1] , buy[i-1] + prices[i]);
        }
        return sell[l-1];
    }
}