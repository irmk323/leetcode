class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }
       // filling out the max diff the case between player 1 and 2;
        // go throught the diagnal order of right bottom;
        // n = 4 
        // 1 round : [0, 1] [1,2], [2,3]
        // 2 round : [0, 2] [2,3]
        // 3 round : [0,3]
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