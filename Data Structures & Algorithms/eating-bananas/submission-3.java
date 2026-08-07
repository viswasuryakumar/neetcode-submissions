class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; // these are the no.of bananas koko can eat in an hr
        int high = 0;
 // Maximum possible eating speed needed
    for(int pile:piles){
        high =  Math.max(high,pile);
    }

while(low<=high){
    int mid = low + (high-low)/2;
    long hours=0;
     // Calculate hours needed if Koko eats at speed "mid"
    for(int pile:piles){
        hours += (int)Math.ceil((double)pile/mid);
    }
    if(hours <= h ){
        // mid works, but maybe a smaller speed also works
        high = mid-1;
    }
    else{
         // mid is too slow
        low = mid+1;
    }

}
return low;
    }
}
