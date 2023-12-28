class Solution {
    // p player, i current index inside piles, m -> how much the player takes.
    private int f(int[] piles, int[][][] dp, int p, int i , int m){
        int n = piles.length;
        if(i == n){
            return 0;
        }
        if(dp[p][i][m] != -1){
            return dp[p][i][m];
        }

        int res = p == 1 ? Integer.MAX_VALUE: -1;
        int s = 0;
        for(int x = 1; x <= Math.min(2 * m , n - i); x++){
            if(p == 0){
                s += piles[i+x -1];
                res = Math.max(res, s+ f(piles, dp, 1, i+x, Math.max(m, x)));
            }
            else{
                res = Math.min(res, s + f(piles, dp, 0, i+x, Math.max(m, x)));
            }
        }
        dp[p][i][m] = res;
        return dp[p][i][m];
        
    }
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length+1][piles.length+1];
        for(int p = 0; p < 2; p++){
            for(int i =0; i<= piles.length; i++){
                for(int m = 0; m<= piles.length; m++){
                    dp[p][i][m] = -1;
                }
            }
        }
        return f(piles, dp, 0,0,1);  
    }
}