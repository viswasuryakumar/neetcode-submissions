class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];   // dp[i] = length of LIS ending at index i
        Arrays.fill(dp, 1);
        int best = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
/* first we will take a dp array of size nums.length, in that fill evrything
 with 1 because at any  index that indexed element can be sequence right,
  that means it can be of length 1. And then we keep two points first j then i and 
  check if ith inxsed element is great than jth(becoz tats how sequence goes 1<2),
  if it is true, then that means ith indexed is atleast 1 greater than jth indexed, 
  as when they co,bined they form a sequence, and we are saying atleast 1 greater 
  than jth index because there can be more nums in btw. so thats why we'll chcek if 
  dp[j]+1 > dp[i](becoz we might have found 2 sewunece for this in the prev loop, 
  as we are startiung the loop again by from j by incrementing i, we have tp cehck 
  this dp[j]+1 > dp[i]). which we can also do by using max. and then we keep tarck 
  of the best max. and at last we return that max. */