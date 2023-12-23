
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().orElseThrow();
        int ans = binarySearch(1, max, h ,piles);
        return ans; 
    }
    private int calcTotalHour(int mid , int[] piles){
        return (int)Arrays.stream(piles)
                .mapToDouble(pile -> Math.ceil((double)pile / mid))
                .sum();
    }
    private int binarySearch(int start, int end, int h,int[] piles ){
        int l = start, r = end;
        int res = end;
        while(l <= r ){
            int mid = (l + r) /2;
            if(calcTotalHour(mid, piles) <= h){
                res = Math.min(res, mid);
                r = mid -1;
            }else{
                l = mid +1;
            }
        }
        return l;
    }
}









class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[piles.length -1];
        int ans = binarySearch(1, max, h ,piles);
        return ans; 
    }
    private int calcTotalHour(int mid , int[] piles){
        int ans = 0;
        for(int pile: piles){
            // without double... 0.222 -> 0.0 so can't be counted as one..
            ans+= Math.ceil((double)pile/mid);
        }
        return ans;    
    }
    private int binarySearch(int start, int end, int h,int[] piles ){
        int l = start, r = end;
        int res = end;
        while(l <= r ){
            int mid = (l + r) /2;
            if(calcTotalHour(mid, piles) <= h){
                res = Math.min(res, mid);
                r = mid -1;
            }else{
                l = mid +1;
            }
        }
        return l;
    }
}

// assume there's 1 to max of pile
// piles = [3,6,7,11], h = 8
// [1,2,3,4,5,6....11]　
// if start from k = 6, calc the hours
// 3 /6 = 1
// 6 /6 = 1
// 7 /6 = 2
// 11/6 = 2
// totally 1+1+2+2 = 6 so still 6< 8, you can try less num.

// O(nlogn * P )