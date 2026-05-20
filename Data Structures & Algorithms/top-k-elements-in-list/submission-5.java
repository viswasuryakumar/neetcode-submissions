class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key: hm.keySet()){
            int freq = hm.get(key);
            if(bucket[freq]==null)
                 bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        int[] result = new int[k];
        int index=0;
        for(int i=bucket.length-1;i>=0 && index<k ;i--){
            if(bucket[i]!=null){
                for(int n:bucket[i]){
                    result[index++] = n;
                    if(index==k){
                       break;}
                }
            }
        }
      return result;  

    }
    
}
