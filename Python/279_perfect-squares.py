class Solution:
    def numSquares(self, n: int) -> int:
        # typical dp question!
        # do not try to do 12 = 4 + 4 + 4.
        # records each dp[i] and return the last element
        square_num = [i**2 for i in range(0,int(math.sqrt(n))+1)]
        dp = [float('inf')] * (n+1)
        dp[0] = 0

        for i in range(n+1):
            for num in square_num:
                if i < num:
                    break
                dp[i] = min(dp[i],1+dp[i-num])
        return dp[-1]   