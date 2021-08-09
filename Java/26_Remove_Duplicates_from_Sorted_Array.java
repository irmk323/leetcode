//use 2 pointer
//Time complextiy O(n)
// Space complexity : O(1).

class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for(int j = 1; j<nums.length; j++){
            if(nums[p] != nums[j]){
                p++;
                nums[p] = nums[j];
            }
        }
        return p+1;
    }
}
