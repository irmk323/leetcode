//Time: O(n) Space: O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, zero = 0,  k =1;
            for(int l = 0, h = 0; h<nums.length; h++){
               if(nums[h] == 0)
                   zero++;
                // while zero is 2
                while(zero > k )
                    // if left pointer is 0, reset the number of 0
                    if(nums[l++] == 0)
                        zero--;
                max = Math.max(max, h-l+1);
            }
        return max;
    }
}
