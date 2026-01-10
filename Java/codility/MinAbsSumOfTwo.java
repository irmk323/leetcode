// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // do the sort and take from both side,
        // it's good if its' closed to 0

        int n = A.length;
        Arrays.sort(A);
        int i = 0;
        int j = n-1;
        long min = Long.MAX_VALUE;
        while(i<=j){
            long sum = (long)A[i] + (long)A[j];
            long abs = Math.abs(sum);
            if(abs < min) min = abs;
            if(min == 0) return 0;
            if(sum < 0){
                i++;
            }else{
                j--;
            }
        }
        return (int)min;
    }
}
