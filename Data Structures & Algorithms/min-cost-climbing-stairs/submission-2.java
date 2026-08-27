class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n =  cost.length;
        int prev1 = 0; // min cost to reach step i-1
        int prev2 = 0; // min cost to reach step i-2

        for(int i=2;i<=n;i++){
            int cur = Math.min(prev1+cost[i-1], prev2+cost[i-2]);
            prev2 = prev1;
            prev1=cur;
        }
        return prev1;
    }
}
