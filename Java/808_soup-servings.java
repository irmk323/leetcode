class Solution {
    
    public double soupServings(int n) {
        if (n >= 4800) { // observe this num. a has higher probability 
            return 1.0;
        }
        int N = (n + 24) / 25; // ceil. e.g 26ml gives 2 serves.
        double[][] dp = new double[N + 1][N + 1];
        return helper(dp, N, N);
    }

    public double helper(double[][] memo, int a, int b ){
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1;
        if (b <= 0) return 0;
        if (memo[a][b] > 0) return memo[a][b];

        memo[a][b] = 0.25 * (
            helper(memo, a - 4, b) +
            helper(memo, a - 3, b - 1) +
            helper(memo, a - 2, b - 2) + 
            helper(memo, a - 1, b - 3));
        return memo[a][b];
    }
}
