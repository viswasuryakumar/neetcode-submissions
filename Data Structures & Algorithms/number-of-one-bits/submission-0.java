class Solution {
    public int hammingWeight(int n) {
        /* we do an and operation with 1 with the given number, so it forces you to give the result as 1 if the 
        last number is 1. otherwise 0.
        eg 10111  & 1 =  10111
                         00001
                        ------
                         00001
        and then u right shift so that it wilklk resomve the lasty digit and do the whiklen again. and count the mo.of occurencess

        */
        int count = 0;
        while(n!=0){
            count+=n & 1;
            n>>>=1;
        }
        return count;
    }
}
