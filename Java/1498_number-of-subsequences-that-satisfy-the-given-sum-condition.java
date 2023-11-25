class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int[] pows = calcPows(nums.length, mod);
        int n = nums.length;
        int left = 0, right = n -1, res = 0;
        while(left <= right){
            if(nums[left] + nums[right] > target ){
                right--;
            }else{
                res = (res + pows[right -left] )% mod;
                left++;
            }
        }
        return res;   
    }
    private int[] calcPows(int n , int mod){
        int[] pows = new int[n];
        pows[0] = 1;
        for(int i = 1; i < n; i++){
            pows[i] = (2* pows[i-1]) % mod;
        }
        return pows;
    }
}