class Solution {
    public int rob(int[] nums) {
        if(nums.length <2){
            return nums[0];
        }
        int[] skippingLastHouse = new int[nums.length-1];
        int[] skippingFirstHouse  = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            skippingLastHouse[i] = nums[i];
            skippingFirstHouse[i] = nums[i+1];

        }
        int lootSkippingLast = robHelper(skippingLastHouse);
        int lootSkippingFirst = robHelper(skippingFirstHouse);
        return Math.max(lootSkippingLast,lootSkippingFirst);
    }

    private int robHelper(int[] nums){
        if(nums.length <2)
           return nums[0];
        
        int prev2 = nums[0];
        int prev1 = Math.max(prev2, nums[1]);
        for(int i=2;i<nums.length;i++){
            int current = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = current;

        }
        return prev1;
    }
}
