class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,nums, new ArrayList<>(), res);
        return res;

    }

    private void dfs(int i, int[] nums, List<Integer> cur, List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        // take nums[i]
        cur.add(nums[i]);
        dfs(i+1,nums,cur,res);
        cur.remove(cur.size()-1); // here we are going to remove the elemtn, so that the set will be fresh and we can start the loop -but we wont tak this element this time, by not addign it to the cur.

        // not take nums[i] — also skip every later duplicate of it
        int j=i;
        while(j<nums.length && nums[j]==nums[i]) j++;
        dfs(j, nums, cur, res);

    }
}
