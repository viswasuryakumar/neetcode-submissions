class TimeMap {
     Map<String, ArrayList<TimeStampedValue>> entriesByKey; // this is tyhe maion map, which we staore the string, and the coessponding all timetsamps
    public TimeMap() {
        entriesByKey =  new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!entriesByKey.containsKey(key)){
            entriesByKey.put(key, new ArrayList<>());
        }

        entriesByKey.get(key).add(new TimeStampedValue(timestamp, value));

    }


    
    public String get(String key, int timestamp) {
        if (!entriesByKey.containsKey(key)) return "";
        ArrayList<TimeStampedValue> values = entriesByKey.get(key);
        int idx = binarySearchTimestamp(values, timestamp);

       return idx == -1 ? "" : values.get(idx).value;
    }

     private int binarySearchTimestamp(ArrayList<TimeStampedValue> arr, int target) {
        int left = 0, right = arr.size() - 1;
        int matchIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid).timestamp <= target) {
                matchIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return matchIndex;
    }
}

class TimeStampedValue{
    public int timestamp;
    public String value;
     public TimeStampedValue(int timestamp, String value){
         this.timestamp = timestamp;
        this.value = value;
     }
}
