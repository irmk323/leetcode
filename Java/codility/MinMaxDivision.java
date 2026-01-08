// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int K, int M, int[] A) {
        // Implement your solution here
        long sum = 0;
        int max = 0;
        for(int a : A){
            max = Math.max(max, a);
            sum += a;
        }

        // do binrary search
        long low = max;
        long high = sum;
        while(low <= high){
            long mid = (low + high )/2;
            if(canDevide(mid, K, A )){
                high =  mid-1;
            }else{
                low = mid+1;
            }
        }
        return (int)low;
    }
    private boolean canDevide(long mid, int K, int[] A){
        int blocks = 1;
        int cur = 0;
        for(int a : A){
            if(cur + a > mid){
                blocks++;
                cur = a;
                if(blocks > K) return false;
            }else{
                cur += a;
            }
        }
        return true;
    }
}
