class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      int n = s.length();
      boolean[] dp = new boolean[n+1];
      dp[n] = true;
      for(int i = n-1; i >= 0 ; i--){
        for(String word: wordDict  ){
          int curLen = i + word.length();
          if( curLen <= n && s.substring(i, curLen).equals(word)){
            dp[i] = dp[curLen];
          }
          if(dp[i]){
            break;
          }
        }
      }
      return dp[0];
    }
}