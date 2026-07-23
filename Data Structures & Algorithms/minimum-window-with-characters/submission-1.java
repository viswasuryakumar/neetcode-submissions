class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length()==0 || t.length()==0) return "";
        //frequency map of chars we need
        Map<Character, Integer> need = new HashMap<>();
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int required = need.size(); // number of DISTINCT chars that must be fully matched
        int formed = 0;  // number of distinct chars currently fully matched
        Map<Character, Integer> windowCounts = new HashMap<>();
        int left = 0;
        int bestLeft = 0;
        int bestLen = Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            windowCounts.put(c,windowCounts.getOrDefault(c, 0) + 1);
            // If this char is one we need, and we've just reached the required count for it
            if(need.containsKey(c) && windowCounts.get(c).intValue() == need.get(c).intValue()){
                formed++;

            }
            // Try to shrink the window from the left as long as it's still valid
            while(formed == required){
                // Update best window
                if(right -left+1 < bestLen){
                    bestLen =  right - left+1;
                    bestLeft = left;
                }
                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                // If shrinking breaks the requirement for this char, decrement formed
                if (need.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestLeft,bestLeft + bestLen) ;   }

}
