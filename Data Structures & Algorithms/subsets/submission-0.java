class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (i == nums.length) {          // decided on every element
            res.add(new ArrayList<>(cur)); // copy! cur keeps mutating
            return;
        }
        cur.add(nums[i]);                 // choose
        dfs(i + 1, nums, cur, res);
        cur.remove(cur.size() - 1);       // un-choose (backtrack)

        dfs(i + 1, nums, cur, res);       // skip nums[i]
    }
}