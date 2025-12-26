package Java.codility;

/**
 * ChocolatesByNumbers - Codility Lesson 12: Euclidean Algorithm
 * Difficulty: Easyv
 *
 * PROBLEM DESCRIPTION:
 * Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle,
 * numbered from 0 to N − 1.
 *
 * You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
 *
 * You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle,
 * and eat the following one.
 *
 * More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N
 * (remainder of division).
 *
 * You stop eating when you encounter an empty wrapper.
 *
 * TASK:
 * Write a function that, given two positive integers N and M, returns the number of chocolates that you will eat.
 *0,1,2,3,4,5,6,7,8,9
 * EXAMPLES:
 * Example 1:
 * Input: N = 10, M = 4
 * Sequence: 0 → 4 → 8 → 2 → 6 → 0 (stop, wrapper found)
 * Output: 5
 *The smallest k where this happens is k = N/GCD(N,M)
 * 
 * Example 2:
 * Input: N = 12, M = 3
 * Sequence: 0 → 3 → 6 → 9 → 0 (stop, wrapper found)
 * Output: 4
 *
 * Example 3:
 * Input: N = 5, M = 5
 * Sequence: 0 → 0 (stop, wrapper found)
 * Output: 1
 *
 * CONSTRAINTS:
 * - N and M are integers within the range [1..1,000,000,000]
 * - Expected time complexity: O(log(N + M))
 * - Expected space complexity: O(1)
 *
 * KEY INSIGHT:
 * This problem is about finding the cycle length when jumping M positions around a circle of N positions.
 * The cycle will repeat after visiting N/GCD(N,M) positions.
 *
 * Mathematical proof:
 * - We visit positions: 0, M, 2M, 3M, ... (all mod N)
 * - We return to 0 when k*M ≡ 0 (mod N), i.e., when k*M is divisible by N
 * - The smallest k where this happens is k = N/GCD(N,M)
 * - Therefore, we eat exactly N/GCD(N,M) chocolates
 *
 * SOLUTION APPROACH:
 * 1. Calculate GCD(N, M) using Euclidean algorithm
 * 2. Return N / GCD(N, M)
 */

//これでNとMの最小公倍数が最初に包み紙にあうタイミングだとわかる。

//Nが10でMが4の場合、0, 4, 8, 2, 6の順にチョコレートを食べる。（その次は0に戻って包み紙なのでストップ）
//この場合食べるチョコレートは5個。
//0123 4567 8901 2345 6789 0123456789
//0123 0123 0123 0123 0123 012301230123
//それまでに食べたチョコの数は最小公倍数をMで割った数。


//最小公倍数（LCM）
//最大公約数 (GCD)

//LCM(a, b) × GCD(a, b) = a × b
// LCM(a, b) = 
//    今回はこれ(N × M) / GCD(N, M)をMで割りたい
// 
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N, int M) {
        // If see this it returns back on 20th
        // MEANS LCM!!
        // if you device LCM / M = 4 ( you can see 4 times of 0)
        // LCM = (N * M) / GCD
        // 0123 4567 8901 2345 6789 0
        // 0123 0123 0123 0123 0123 0

        // return (N * M)/ gcd(N, M) / M; // This causes overhead. had to use long
        return N/gcd(N,M);
    }
    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}

}