class Solution {
    public int longestSubarray(int[] nums) {
        int k=1,res= 0;
        for (int left = 0, right = 0; right< nums.length; right++){
            if(nums[right] == 0){
                k--;
            }
            while(k < 0){
                if(nums[left]== 0){
                    k++;
                }
                left++;
            }
            res = Math.max(res, right-left);
        }
        return res;
        
    }
}