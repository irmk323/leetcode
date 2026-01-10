// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        if (N == 0) return 0;

        int count = 1;          // 最初は取る
        int lastEnd = B[0];

        for (int i = 1; i < N; i++) {
            if (A[i] > lastEnd) {   // 交差しないなら取る
                count++;
                lastEnd = B[i];
            }
        }
        return count;
    }
}

