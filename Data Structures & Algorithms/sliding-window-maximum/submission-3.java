class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n = nums.length;
       int[] res = new int[n-k+1];  // one window per starting index
       int idx = 0;

       // Deque holds INDICES, not values.
       // values at these indices are strictly decreasing,- monotonic stack
       // so dq.peekFirst() is always the max of the current window.- i.e the bottom element-x | |
                                                                                         //    | |
                                                                                      // last  | x|
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            // 1. EXPIRE: front index has slid out of window [i-k+1, i] , thatmneans if the bottom is lesser tyhen the i-k, that means it's actually out of the winodw, so we'll rermove it
            if(!dq.isEmpty() && dq.peekFirst() <= i-k
            ) {
                dq.pollFirst();
            }
// 2. DOMINATE: anything smaller than nums[i] can never be a max again,
            //    because nums[i] is newer (stays longer) AND bigger. Kill them.
            // here if the currewntr element nums[i] is a smaller one than which is at the top of the  stack then we can push it, as because when that cerrtaiin window comes with nums[i] being the largest one(now it maybe smaller, but there can be time ehere it willl be larger,  BUT BUT if the nums[i]) is the bigger eleemnt than the top of the stack, then we will keep on popping out h eelements, as we certaily know that the new element is the maximum element.- whihc is what we r doing below

            while(!dq.isEmpty() && nums[dq.peekLast()]  <= nums[i]){
                dq.pollLast();
            }

            //so, once it thge while loop is done, we can add the new element.
            // 3. nums[i] is now the smallest at the back — order preserved
            dq.offerLast(i);
            // 4. First full window completes at i == k-1
            if (i >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }


        }
return res;
    }
}
