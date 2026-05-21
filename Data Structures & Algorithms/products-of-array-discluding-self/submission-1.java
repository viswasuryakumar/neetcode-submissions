class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] pref = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];
        pref[0]=1;
        for(int i=1;i<n;i++){
         pref[i] = nums[i-1]*pref[i-1];
        }
        suffix[n-1]=1;
        for(int j=n-2;j>=0;j--){
            suffix[j]=nums[j+1]*suffix[j+1];
        }
        for(int i=0;i<n;i++){
            res[i] = pref[i]*suffix[i];
        }
return res;
    }
}