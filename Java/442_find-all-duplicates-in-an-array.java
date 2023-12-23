class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // This is possible because of 1 ≤ arr[i] ≤ n
        List<Integer> ans = new ArrayList<>();
        for(int n: nums){
            if(nums[Math.abs(n) -1 ] < 0){
                ans.add(Math.abs(n));
            }
            nums[Math.abs(n) -1] *= -1;
        }
        return ans;
    }

}