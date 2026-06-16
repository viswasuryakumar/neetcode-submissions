class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 ) return 0;

        int prev2 = 1;
        int prev1 = s.charAt(0) == '0'? 0 : 1 ;
        for(int i=2 ;i <=s.length();i++){
            int count = 0;
            int onedigit = Integer.valueOf(s.substring(i-1,i));
            int twodigits = Integer.valueOf(s.substring(i-2,i));
            if(onedigit >= 1){
                count += prev1;

            }
            if(twodigits >= 10 && twodigits <= 26){
                count +=prev2;
            }
            prev2 = prev1 ;
            prev1 = count;
        }
        return prev1;
    }
}
