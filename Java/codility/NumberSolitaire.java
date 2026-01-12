// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for(int i = 1; i< n ; i++){
            int bestPrev = Integer.MIN_VALUE;
            for(int j = 1; j<= 6 ; j++){
                int k =i-j;
                if(k>=0){
                    bestPrev = Math.max(bestPrev, dp[k]);
                }
            }
            dp[i] = bestPrev + A[i];
        }
        return dp[n-1];
    }
}






