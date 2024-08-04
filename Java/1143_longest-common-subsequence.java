class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1]; // to fill base cases of 0
        
        char[] t1Chars = text1.toCharArray();
        char[] t2Chars = text2.toCharArray();
        
        for(int c1 = 1; c1 <= len1; c1++){
            for(int c2 = 1; c2 <= len2; c2++){
                if(t1Chars[c1-1] == t2Chars[c2-1]){
                    dp[c1][c2] =  dp[c1 - 1][c2 - 1] + 1;
                }else{
                    dp[c1][c2] = Math.max(dp[c1 -1][c2], dp[c1][c2 - 1]);
                }
                
            }
        }
        return dp[len1][len2];
        
    }
}