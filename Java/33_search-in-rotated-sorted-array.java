class Solution {
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while(left <= right){
            int mid = ( left + right) /2;
            if (nums[mid] == target){
                return mid;
            }
            //  [4,5,6,0,1,2,3], target =1
            if(nums[mid] >= nums[left]){ // In rising trend 
                if(target < nums[mid] && target >= nums[left]){
                    right = mid -1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(   nums[mid] < target && target <= nums[right] ){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }                
            }
        }
        return -1;

    }
}