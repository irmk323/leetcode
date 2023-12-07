class Solution {
    public int mincostTickets(int[] days, int[] costs) {
      int lastDay = days[days.length-1]; 
      int[] dp = new int[lastDay+1]; // For calc the min costs on this day.
      boolean[] isTravelday = new boolean[lastDay+1]; // include all days

      for(int day: days){
        isTravelday[day] = true;
      }

      for(int i =1; i<=lastDay; i++){ // start from 1
        if(!isTravelday[i]){ // if it's not on the travel day, cost is the same.
          dp[i] = dp[i-1];
          continue;
        }else{
          dp[i] = costs[0] + dp[i-1]; // 1day pass 
          dp[i] = Math.min(dp[i] , costs[1] + dp[Math.max(i-7,0)]); // there's no minus index on dp
          dp[i] = Math.min(dp[i] , costs[2] + dp[Math.max(i-30,0)]);
        }
      }
      return dp[lastDay];
        
    }
}