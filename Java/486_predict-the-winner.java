class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }
        // len goes 1- to n-1
        for (int distance = 1; distance < n; distance++) {
            for (int left = 0; left < n - distance; ++left) {
                int right = left + distance;
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right],
                                          nums[right] - dp[left][right - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}