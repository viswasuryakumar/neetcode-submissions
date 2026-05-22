class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int l=0,res=0;
        for(int r=0;r<s.length();r++){
            if(hm.containsKey(s.charAt(r))){
                l=Math.max(l,hm.get(s.charAt(r))+1);
            }
            hm.put(s.charAt(r),r);
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
