class Solution {
    public int maxProfit(int[] prices) {
        int j = 1, i = 0, max = 0;
        while (j < prices.length) {
            if (prices[j] - prices[i] > max) {
                max = prices[j] - prices[i];
            }
            if (prices[j] < prices[i]) {
                i = j;
            }
            j++;
        }
        return max;
    }
}
