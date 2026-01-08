import java.util.*;

class Solution {
    public int solution(int[] A, int[] B, int[] C) {
        int n = A.length;
        int m = C.length;

        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            maxPos = Math.max(maxPos, B[i]);
        }
        for (int i = 0; i < m; i++) {
            maxPos = Math.max(maxPos, C[i]);
        }

        int low = 1;
        int high = m;
        int answer = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canNailAll(mid, C, maxPos, A, B)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private boolean canNailAll(int K, int[] C, int maxPos, int[] A, int[] B) {
        int[] prefix = new int[maxPos + 1];

        for (int i = 0; i < K; i++) {
            prefix[C[i]]++;
        }
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int i = 0; i < A.length; i++) {
            if (prefix[B[i]] - prefix[A[i] - 1] == 0) {
                return false;
            }
        }
        return true;
    }
}

