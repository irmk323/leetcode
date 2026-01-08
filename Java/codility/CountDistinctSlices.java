// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    public int solution(int M, int[] A) {
        boolean[] seen = new boolean[M+1];

        int left = 0;
        long ans = 0;
        for(int right = 0; right< A.length ; right++){
            int v = A[right];
            while(seen[v]){
                seen[A[left]] = false;
                left++;
            }
            seen[v] = true;
            ans += (right - left +1);
            if(ans > 1_000_000_000) return 1_000_000_000;
        }
        return (int)ans;

    }
}