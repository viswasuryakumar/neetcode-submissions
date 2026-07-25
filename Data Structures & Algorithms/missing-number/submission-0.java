class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = n; // account for index n, since array indices only go 0..n-1
        
        for (int i = 0; i < n; i++) {
            result ^= i ^ nums[i];
        }
        
        return result;
    }
}