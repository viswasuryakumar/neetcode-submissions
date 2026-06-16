class Solution {
    int count =0 ;
    public int countSubstrings(String s) {
         count =0 ;
       for(int i=0;i<s.length();i++){
        countpalindrome(s,i,i);
         countpalindrome(s,i,i+1);
       }
       return count;
    }


   public void countpalindrome(String s, int left,int right){
    while(left>=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
        count++;
        left--;
        right++;
    }
   
   }


}
