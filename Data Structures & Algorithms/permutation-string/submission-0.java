class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k =  s1.length();
        if(k>s2.length()) return false; // s1 can't fit in s2 at all

        int[] need_for_s1 = new  int[26];
        int[] window = new int[26];

        // build frequency count for s1 and first window of s2
        for(int i=0;i<k;i++){
         need_for_s1[s1.charAt(i)-'a']++;
         window[s2.charAt(i)-'a']++; 

        }
        if(matches(need_for_s1,window)) return true;

        // slide the window across the rest of s2
        for(int i=k;i<s2.length();i++){
            window[s2.charAt(i)-'a']++;
            window[s2.charAt(i-k)-'a']--;

            if(matches(need_for_s1,window)) return true;
        }
        return false;
    }

     private boolean matches(int[] need, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (need[i] != window[i]) return false;
        }
        return true;
    }
}
