class Solution {
    // n = 21, k = 17, maxPts = 10
    // need a percentage from P(17) + P(18) + ... + P(21)
    // e.g P(21) = P(16) * P(5) +
                // P(15) * P(4) +
                // P(14) * P(3) +
                // ...
                // P(11) * P(10) //P(11) means 21 - maxPts

    // why it start from P(16)? because k =17, so it takes k-1 = 16 in this case.
    // then possibility of P(5), P(4), P(3) is always the same.  ( 1/ maxPts)
    // so  P(i) = 1/maxPts * ( P(k-1) + P(k-2) + ... +P(i-maxPts))

    //But while calculating P(21) to P(17), there's a lot of duplication of calc
    //So just use sliding window technique
    // e. g
    // P(18) = 1/maxPts (P(16) + P(15) ... P(8))
    // P(17) = 1/maxPts (P(16) + P(15) ... P(8) + P(7))
    // P(16) = 1/maxPts         (P(15) + P(14)..+ P(6))
    // P(15) = 1/maxPts                 (P(14)..+ P(6)+ P(5))

    // P(12) = 1/maxPts(P(11) ... +   P(2)) 
    // P(11) = 1/maxPts(P(10)+ P(9) + .... + P(1))
    // P(10) = 1/maxPts(P(9) + P(8) + .... + P(1) + P(0))
    // .... 
    // P(2) = 1/maxPts(P(1) + P(0))
    // P(1) = 1/maxPts(P(0))
    // P(0) = 1
    // so in P(i), if i < k, just add next possibility to sum.
    // and basically cut off the last element as you see P(15) to P(16)
    public double new21Game(int n, int k, int maxPts) {
        if (k ==0 || n >= k + maxPts){
            return 1;
        }
        double[] dp = new double[n+1];
        dp[0] = 1;
        double curSum = dp[0];
        for(int i = 1; i<= n; i++){
            dp[i] = curSum / (double)maxPts;

            // this part is for the calculation of next val (i+1)
            if(i < k){
                curSum += dp[i];
            }
            if(i - maxPts >= 0){
                curSum -= dp[i - maxPts];
            }
 
        }
        double ans = 0;
        for(int i = k; i<=n; i++){
            ans+= dp[i];
        }
        return ans;        
    }
}