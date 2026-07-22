class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()){
        return false;
       }
    HashMap<Character, Integer> hm = new HashMap<>();
    for(int i=0;i<s.length();i++){
        hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);

    }
    for(char c:t.toCharArray()){
        if(!hm.containsKey(c)){
            return false;
        }

        hm.put(c,hm.get(c)-1);
        if(hm.get(c)<0){
            return false;
        }
    }

    for(int count:hm.values()){
        if(count!=0)
           return false;
    }

    return true;
    }
}
