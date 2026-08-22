class Solution {
    public boolean checkValidString(String s) {
        int low = 0;  // min possible unmatched '(' count
        int high = 0; // max possible unmatched '(' count
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*'
                low--;   // treat as ')' or ""
                high++;  // treat as '('
            }
            
            if (high < 0) {
                // too many ')' — no way to recover
                return false;
            }
            
            if (low < 0) {
                // can't have negative unmatched opens; clamp
                low = 0;
            }
        }
        
        return low == 0;
    }
}