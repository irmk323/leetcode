// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // If A <= B <= C, it can make a triangle
        // so if A + B < c, it's triangle
        int ans =0;
        int n = A.length;
        // sort A, 
        Arrays.sort(A);
        // take longest one as C

        for(int c= n-1; c >= 2; c--){
            int a = 0;
            int b = c -1;

            while(a < b){
                long sum = (long)A[a] + (long)A[b];
                if(sum > A[c]){
                    ans += (b - a) ;
                    b--;
                }else{
                    a++;
                }
            }

        }
        return ans;
    }
}
//まず三角形条件（これだけ）
//
//辺を a ≤ b ≤ c に並べると、三角形になる条件は これだけ：
//
//a + b > c
//
//他の2つ（a+c>b, b+c>a）は自動で満たされる（正の長さだから）。
//
//解法の全体像
//
//配列を 昇順ソート
//
//c を固定（「一番長い辺」だと思う）
//
//その左側から (a,b) の組を数える