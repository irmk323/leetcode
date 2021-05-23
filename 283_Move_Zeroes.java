class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, j = 0; i < nums.length && j < nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
