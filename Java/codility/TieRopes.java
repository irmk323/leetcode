/ you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int K, int[] A) {
        int count = 0;
        int sum = 0;
        for(int a: A){
            sum += a;
            if(sum >= K){
                count ++;
                sum = 0;
            }
        }
        return count;
    }
}






