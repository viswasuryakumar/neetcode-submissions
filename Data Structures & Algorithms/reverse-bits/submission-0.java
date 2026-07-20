class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // shift result left to open a slot at bit 0
            result |= (n & 1);     // drop n's current LSB into that slot
            n >>>= 1;              // discard n's LSB, next bit becomes new LSB
        }
        return result;
    }
}