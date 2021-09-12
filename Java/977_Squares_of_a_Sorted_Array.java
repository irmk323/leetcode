// Time O(n)
// Space O(n)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        int left = 0, right = n -1;
        for(int i = n-1; i>=0; i--){
            int square;
            if(Math.abs(nums[left]) < Math.abs(nums[right]) ){
                square = nums[right];
                right--;
            }else{
                square = nums[left];
                left++;
            }
            ret[i] = square * square;
        }
        return ret;
    }
}
