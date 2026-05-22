class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0 || nums==null)
            return 0;
        HashSet<Integer>  numSet = new HashSet<Integer>();
        for(int n: nums){
            numSet.add(n);
        }
        int maxLength = 0;
        for(int i: numSet){
            if(!numSet.contains(i-1)){
                int currentsequencenumber= i;
                int currentLength = 1;

                while(numSet.contains(currentsequencenumber+1)){
                    currentsequencenumber++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
 return maxLength;
    }
   
}