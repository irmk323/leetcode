// Time O(n)
// Space O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int cur_max = nums[0];
        int cur_win = nums[0];
        // int cur_num = nums[0];
        // int l = 0;
        // int r = 0;
        for(int r = 1; r< nums.length; r++){
            cur_win = Math.max(nums[r], cur_win + nums[r]);
            cur_max = Math.max(cur_max, cur_win);
             // cur_num = nums[r]
            // if (cur_win > cur_max){
            //     cur_max = cur_win;
            // }
            // if (nums[r] > cur_max){
            //     cur_max = nums[r];
            //     cur_win =  nums[r];
            // }
            // if (nums[r] > cur_win){
            //     cur_win = nums[r];
            // }
        }
        return cur_max;        
    }
}

// [8,-19,5,-4,20]
    
// cur_max 8
// cur_win -10 

//   l r

// l = 1   -2 
// r = 1   1

// cur_max 2  
// cur_win 1
// cur_num = 999              