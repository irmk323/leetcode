// Time:O(1)
// Space:O(n)
// Updated 11/Aug

class Solution {
public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        

    int insertPos = 0;
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}
}


///=============================

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
