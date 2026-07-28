class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        dp[0]=1;   // base case: 1 way to make 0
        for(int coin:coins){    // bring in coins ONE AT A TIME
            for(int i=coin;i<=amount;i++){
                dp[i] = dp[i]/* ways to make this amount using coins seen so far, without this coin*/+ dp[i-coin]/* ways to make this amount by using this coin at least once */;

            }
        }
        return dp[amount];
    }
}