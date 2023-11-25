class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long regTotal = 0, expTotal = expressCost;
        long[] cost = new long[regular.length];
        for(int i = 0; i< regular.length; i++){
            long temp = regTotal;
            // this is checking pass by reg station from prev reg or prev exp
            regTotal = Math.min(expTotal, regTotal ) + regular[i];
            // this is checking pass by exp station from prev reg or prev exp
            expTotal = Math.min(expTotal, temp + expressCost ) + express[i];
            cost[i] = Math.min(regTotal, expTotal);
        }
        return cost;
        
    }
}