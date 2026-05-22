class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int bought =prices[0];
        for(int i=1;i<prices.length;i++){
           int profit_for_this_one = prices[i]-bought;
           profit = Math.max(profit_for_this_one,profit);
           bought =  Math.min(bought,prices[i]);
        }
        return profit;
    }
}
