class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
         
        for(int i=0 ; i < k;i++){
            sum += nums[i];
        }
        double max = sum;
                    
        // [1,12,-5,-6,50,3]
        for(int i = k; i< nums.length; i++){
            sum += nums[i] - nums[i-k];
            max = Math.max(max , sum);
        }
        return max/k;
    }
}