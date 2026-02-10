// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// LTE ==========
// LTE ==========
// LTE ==========
class Solution {
    public int solution(int[] A) {
        int S = 0;
        for(int i = 0 ; i< A.length; i++){
            A[i] = Math.abs(A[i]);
            S += A[i];
        }
        boolean[] dp = new boolean[S+1];
        dp[0] = true;

        for(int v : A){
            for(int s = S; s >=v ; s--){
                if(dp[s-v]){
                    dp[s] = true;
                }
            }
        }
        int best = S;
        for(int s = 0 ; s <= S/2; s++){
            if(dp[s]){
                best = Math.min(best, S - 2 *s );
            }
        }
        return best;
    }
}

// LTE ==========
// LTE ==========
// LTE ==========



import java.util.*;

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) return 0;

        // 1) 絶対値にして合計Sと最大値maxを取る
        int S = 0, max = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Math.abs(A[i]);
            S += A[i];
            if (A[i] > max) max = A[i];
        }

        // 2) 同じ値をまとめる（count[v] = vの個数）
        int[] count = new int[max + 1];
        for (int v : A) count[v]++;

        // 3) dp[s]:
        //   -1 なら作れない
        //   >=0 なら作れる（かつ今のvをあと何回使えるかの残量）
        int[] dp = new int[S + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        // 4) 値 v をまとめて処理（ここが高速化のコア）
        for (int v = 1; v <= max; v++) {
            if (count[v] == 0) continue;

            for (int s = 0; s <= S; s++) {
                if (dp[s] >= 0) {   
                    // すでに作れる s は「v を count[v] 回まで使える状態」にする
                    dp[s] = count[v];
                } else if (s >= v && dp[s - v] > 0) {
                    // s-v が作れて、まだ v を使えるなら v を足して s も作れる
                    dp[s] = dp[s - v] - 1;
                }
            }
        }

        // 5) S/2 に一番近い s を探す（差 = S - 2*s）
        int best = S;
        for (int s = 0; s <= S / 2; s++) {
            if (dp[s] >= 0) {
                best = Math.min(best, S - 2 * s);
            }
        }
        return best;
    }
}




