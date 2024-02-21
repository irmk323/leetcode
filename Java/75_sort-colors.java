class Solution {
    public void sortColors(int[] nums) {
        int L = 0, cur = 0, R = nums.length-1;
        while(cur <= R){
            if(nums[cur] ==0){
                swap(nums, cur, L);
                L++;
                cur++;
            }else if(nums[cur] == 2){
                swap(nums, cur, R);
                R--;
            }else{
                cur++;
            }
        }
        
    }
    private void swap(int[] nums, int cur, int replace){
        int temp = nums[replace];
        nums[replace] = nums[cur];
        nums[cur] = temp; 
    }
}