class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length ==0)
           return new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap<>();
        for(String str:strs){
            String key = getFrequencyString(str);
            if(!hm.containsKey(key)){
                hm.put(key,new ArrayList<>());
            }
            hm.get(key).add(str);
        }
        return new ArrayList<>(hm.values());
    }


    private String getFrequencyString(String str){
        int[] freq = new int[26];
        for(char c:str.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char c ='a';
        for(int count:freq){
            sb.append(c);
            sb.append(count);
            c++;
        }
        return sb.toString();
    }
}
