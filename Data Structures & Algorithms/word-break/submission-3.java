class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
         // 1. Set for O(1) lookups instead of O(k) list scans
         HashSet<String> wordSet = new HashSet<>(wordDict);

          // 2. Longest word length — used to bound the inner loop
          //we only need to look back till the longest length
          int maxLen =0 ;
          for(String word:wordDict){
            maxLen = Math.max(maxLen,word.length());

          }
          int n = s.length();
          boolean[] dp = new boolean[n+1];
          dp[0] = true;   // because we are creating a new place dp[0] 
          //saying that we can even not take anything from the dict
          //for each inde  we will store if the character at that place is found or 
          //characters tilll maxlength back(in s) is found in the dictonary.
          for(int i=1;i<=n;i++){
            // Only look back at most maxLen characters
            for(int j=i-1;j>=Math.max(0,i-maxLen);j--){
                if(dp[j]/* we are checking becoz even at a certain point if the found the 
                element for the current index- the prev index should be true stating that 
                okay  we have found these prev elements in the dict too like id  catand is 
                there if we are standing at d and found and, the index at t should be true 
                stating that that part is found too sayig that whole "s" is there in
                 the dict*/ && wordSet.contains(s.substring(j,i))){
                    dp[i] =  true;
                    break;
                 }
            }
          }
          return dp[n]; // the last index will be stroiung the whole strings trueness
    }
}
