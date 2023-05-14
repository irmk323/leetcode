class Solution {
    public int climbStairs(int n) {
        if(n == 1) return n;
        
        int oneStep = 1;
        int twoStep = 2;
        for(int i = 3; i <= n; i++){
            int tmp = twoStep;
            twoStep = twoStep + oneStep;
            oneStep = tmp;
        }
        return twoStep;
    }
        //this is also accepted but not optimized in term of space O(n), above is O(1)
        // int[] dp = new int[n + 1];
        // dp[1] = 1;
        // dp[2] = 2;
        // for(int i = 3; i <= n; i++){
        //     dp[i] = dp[i -1] + dp[i -2];
        // }
        // return dp[n];
    }
}
