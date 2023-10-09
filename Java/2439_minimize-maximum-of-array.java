class Solution {
    public int minimizeArrayValue(int[] nums) {
        double max = nums[0], total = nums[0];
        for(int i = 1; i< nums.length; i++){
            total += nums[i];
            max = Math.max(max, Math.ceil(total/ (i+1))); // 7.3 -> 8.0
        }
        return (int)max;
    }
}

// [3,7,1,6]
// [4,6,1,6]
// [4,6,2,5]
// [5,5,2,5]
// [5,5,2,5]