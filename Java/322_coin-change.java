// Space O(N)
// Time  O(N)
class Solution {
    public int coinChange(int[] coins, int amount) {
      // not necessary to be Integer.MAX_VALUE
      int bigNum = amount +1;

      int[] dp = IntStream.range(0, amount + 1)
                    .map(i -> (i == 0) ? 0 : bigNum)
                    .toArray();

      for(int i = 1; i <= amount; i++){
        for(int coin : coins){
          int rem = i - coin; // remaining amount
          if(rem < 0 || dp[rem] == bigNum ){
            continue;
          }
          dp[i] = Math.min(dp[i], dp[rem] +1);
        }
      }
      return dp[amount]== bigNum ? -1: dp[amount];
    }
}