class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;

        // [4,5,rob1, nob2, curN, curN+1, ...]
        // so working on n, then shift to right
        // [4,5, ?  , nob1, nob2, curN, curN+1,...]
        for(int n : nums){
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;

        
    }
}