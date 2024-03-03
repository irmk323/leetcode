class Solution {

    private int contValidPairs(int[] nums, int threshold){
        int index = 0, count = 0;
        while(index < nums.length -1){
            if(nums[index +1 ] - nums[index] <= threshold){
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int  n = nums.length;
        int left = 0, right = nums[n-1];
        while(left <= right){
            int mid = (left + right) / 2;

            if(contValidPairs(nums, mid) >= p){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}