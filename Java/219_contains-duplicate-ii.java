class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k ==0){
            return false;
        }
        int left = 0;
        int right = 0;
        while(left < nums.length-1 ){
            right = left+1;
            while( right < nums.length && right - left <= k){
                if(nums[left] == nums[right]){
                    return true;
                }
                right++;
            }
            left++;
        }
        return false;
    }
}