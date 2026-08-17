class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums){
        //the base condition is gonna be
        // If we've picked as many numbers as nums has, it's a complete permutation
        if(tempList.size() == nums.length){
            ans.add(new ArrayList<>(tempList));
            return;
        }

        for(int number :nums){
           // Skip if this number is already used in the current permutation
            if(tempList.contains(number)) continue;

            tempList.add(number); //taking the element
            backtrack(ans,tempList,nums);//inorder to add the other elemnt , we willlg o back, and add the other element following the rules
            tempList.remove(tempList.size()-1);
        }
    }
}

/*
we will use the for loop to traverse through the array. In that, we will take the first element, and then we will add it into the temp list, and then in order to add the second one, we will go back and use the same for loop, but we will use the condition so that we won't be taking the same element again. Once it's not the duplicate, we will add it into the temp list, and then do the backtrack again. Once that's done, we will remove the element from the temp list, and then we will take the second element / other element in the loop and do the same process again
*/