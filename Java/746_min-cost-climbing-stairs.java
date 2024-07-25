class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int d1 =0, d2 = 0;
        // cost.length+1 means calc from the top
        for(int i =2 ; i< cost.length+1; i++){
            int temp = d1;
            d1= Math.min(cost[i-1]+ d1, cost[i-2]+ d2);
            d2 = temp;
        }
        return d1;
    }
}