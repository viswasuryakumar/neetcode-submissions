class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //iterate over each cell and update values
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
/*
LCS DP Recurrence - Quick Notes

dp[i][j] = LCS of first i chars of str1, first j chars of str2.

Match (text1[i-1] == text2[j-1]): dp[i][j] = 1 + dp[i-1][j-1] → equal chars can always be paired up, so take the answer before both chars existed, +1.

Mismatch: dp[i][j] = max(dp[i-1][j], dp[i][j-1]) → one of the two chars is definitely NOT in the LCS, don't know which, so try dropping each one and take the better result. Up ≠ left usually, since they're different sub-problems (drop-from-str2 vs drop-from-str1) — that's why max is needed, not just picking one.

Interview line: "Match → diagonal+1 (exchange argument). Mismatch → max(up, left), since one char must be excludable and max picks the correct exclusion."
*/