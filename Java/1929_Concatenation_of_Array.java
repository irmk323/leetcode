class Solution {
    public int[] getConcatenation(int[] nums) {
    
      int[] nums_double = new int[nums.length * 2];
        for(int i = 0; i < nums_double.length; i++)
        {
            nums_double[i] = nums[i%nums.length];
        }
    return nums_double;
    }
}

// time ...  O(n)
// space O(n) 
