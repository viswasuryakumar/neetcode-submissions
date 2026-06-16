class Solution {
    public int reslen = 0;
    public  int resInd = 0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            expandaroundcenter(s,i,i);
            expandaroundcenter(s,i,i+1);
        }
        return s.substring(resInd,resInd+reslen);
    }


    public void expandaroundcenter(String s, int left, int right ){
        while(left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right) ){
            int currentlen = right - left+1;
            if(currentlen>reslen){
                resInd = left;
                reslen = currentlen;

            }
            left--;
            right++;
        }
    }
}
