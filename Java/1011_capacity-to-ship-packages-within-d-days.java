class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // at least need a max weight of size of ship 
        // e.g [3,2,2,4,1,4] => at least 4 
        // also if day is one, need a size of total(weights)
        int maxWeight = Arrays.stream(weights).max().orElseThrow();
        int sum = Arrays.stream(weights).sum();
        int ans = binarySearch(weights, days, sum, maxWeight);
        return ans;
    }
    private boolean canShipWithThisWeight(int mid, int[] weights, int days){
        //day starts one.
        int curDay = 1, curWeight =0;
        for(int weight : weights){
            curWeight += weight;
            if(curWeight > mid){
                curDay++;
                curWeight = weight; // left over to next ship
            }
        }
        return curDay <= days;
    }
    private int binarySearch(int[] weights, int days, int sum, int maxWeight){
        int l = maxWeight , r = sum;
        while(l <= r){
            int mid = (l + r) /2;
            // [3,2,2,4,1,4] if you can pack, want to minimize
            if (canShipWithThisWeight(mid,weights,days)){
                r = mid -1;
            }else{
                l = mid +1;
            }
        }
        return l;
    }
}