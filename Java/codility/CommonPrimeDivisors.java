package Java.codility;

/**
 * CommonPrimeDivisors - Codility Lesson 12: Euclidean Algorithm
 * Difficulty: Medium
 *
 * PROBLEM DESCRIPTION:
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X.
 * The first few prime numbers are: 2, 3, 5, 7, 11, 13, ...
 *
 * A prime D is called a prime divisor of a positive integer P if there exists a positive integer K
 * such that D × K = P. For example, 2 and 5 are prime divisors of 20.
 *
 * You are given two positive integers N and M. The goal is to check whether N and M have the same
 * set of prime divisors.
 *
 * For example, given:
 * - N = 15 and M = 75, they have the same set of prime divisors: {3, 5}
 * - N = 10 and M = 30, they do not have the same set: {2, 5} vs {2, 3, 5}
 *
 * TASK:
 * Write a function that, given two arrays A and B of Z integers, returns the number of positions K
 * for which A[K] and B[K] have the same set of prime divisors.
 *
 * EXAMPLES:
 * Example 1:
 * Input: A = [15, 10, 3], B = [75, 30, 5]
 * Analysis:
 *   - A[0]=15 has prime divisors {3, 5}, B[0]=75 has prime divisors {3, 5} → MATCH
 *   - A[1]=10 has prime divisors {2, 5}, B[1]=30 has prime divisors {2, 3, 5} → NO MATCH
 *   - A[2]=3 has prime divisors {3}, B[2]=5 has prime divisors {5} → NO MATCH
 * Output: 1
 *
 * Example 2:
 * Input: A = [1, 1], B = [1, 1]
 * Analysis: 1 has no prime divisors (special case), both match
 * Output: 2
 *
 * CONSTRAINTS:
 * - Z is an integer within the range [1..6,000]
 * - Each element of arrays A and B is an integer within the range [1..2,147,483,647]
 * - Expected time complexity: O(Z * log(max(A) + max(B))²)
 * - Expected space complexity: O(1)
 *
 * HINTS:
 * 1. Two numbers have the same set of prime divisors if and only if they can be reduced to
 *    the same number by repeatedly dividing by their GCD.
 *
 * 2. Key insight: If gcd(a, b) = g, then a and b have the same prime divisors if:
 *    - All prime factors of a are in g
 *    - All prime factors of b are in g
 *
 * 3. To check if all prime factors of a number n are in g:
 *    - Keep dividing n by gcd(n, g) until n becomes 1 or gcd(n, g) becomes 1
 *    - If n becomes 1, all prime factors are in g
 *    - If gcd(n, g) becomes 1 but n > 1, then n has prime factors not in g
 *
 * 4. Algorithm outline:
 *    a) Calculate g = gcd(A[K], B[K])
 *    b) Check if all prime factors of A[K] are in g
 *    c) Check if all prime factors of B[K] are in g
 *    d) If both checks pass, they have the same prime divisors
 *
 * 5. Helper function needed: A function to check if all prime divisors of n are in g:
 *    - While gcd(n, g) > 1:
 *      - Keep dividing n by gcd(n, g)
 *    - Return true if n becomes 1, false otherwise
 *
 * 6. Edge cases to consider:
 *    - When A[K] = 1 or B[K] = 1 (special case: 1 has no prime divisors)
 *    - When A[K] = B[K] (always have same prime divisors)
 *
 * MATHEMATICAL BACKGROUND:
 * - If gcd(a, b) = g, then a = g × a' and b = g × b' where gcd(a', b') = 1
 * - For a and b to have the same prime divisors, both a' and b' must be 1
 * - This can be checked by repeatedly dividing by the gcd
 */
public class CommonPrimeDivisors {

    // TODO: Implement your solution here
    public int solution(int[] A, int[] B) {
        int N = A.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int a = A[i];
            int b = B[i];
            int g = gcd(a, b);
            if(a == 1 || b == 1  ) {
                continue;  //?
            }
            if(a==b ||  AreAllPrimesInGCD(a,g) &&
                    AreAllPrimesInGCD(b,g)){
                count++;
            }
        }
        return count;
    }

    /**
     * Helper function: Calculate GCD using Euclidean algorithm
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public boolean AreAllPrimesInGCD(int n, int g) {
        while( gcd(n, g) > 1 ){
           n = n / gcd(n, g);
        }
        return  n == 1;
    }

    // ==================== TEST CASES ====================

    public static void main(String[] args) {
        CommonPrimeDivisors solution = new CommonPrimeDivisors();

        // Test Case 1: Example from problem
        System.out.println("Test 1 - Basic example:");
        int[] A1 = {15, 10, 3};
        int[] B1 = {75, 30, 5};
        int result1 = solution.solution(A1, B1);
        System.out.println("Input: A=[15,10,3], B=[75,30,5]");
        System.out.println("Expected: 1");
        System.out.println("Got: " + result1);
        System.out.println("Explanation: Only pair (15,75) has same prime divisors {3,5}");
        System.out.println();

        // Test Case 2: All ones
        System.out.println("Test 2 - All ones:");
        int[] A2 = {1, 1};
        int[] B2 = {1, 1};
        int result2 = solution.solution(A2, B2);
        System.out.println("Input: A=[1,1], B=[1,1]");
        System.out.println("Expected: 2");
        System.out.println("Got: " + result2);
        System.out.println("Explanation: 1 has no prime divisors (special case)");
        System.out.println();

        // Test Case 3: Same numbers
        System.out.println("Test 3 - Identical pairs:");
        int[] A3 = {2, 3, 4, 5};
        int[] B3 = {2, 3, 4, 5};
        int result3 = solution.solution(A3, B3);
        System.out.println("Input: A=[2,3,4,5], B=[2,3,4,5]");
        System.out.println("Expected: 4");
        System.out.println("Got: " + result3);
        System.out.println("Explanation: Identical numbers always have same prime divisors");
        System.out.println();

        // Test Case 4: Powers of same prime
        System.out.println("Test 4 - Powers of 2:");
        int[] A4 = {2, 4, 8, 16};
        int[] B4 = {2, 16, 4, 32};
        int result4 = solution.solution(A4, B4);
        System.out.println("Input: A=[2,4,8,16], B=[2,16,4,32]");
        System.out.println("Expected: 4");
        System.out.println("Got: " + result4);
        System.out.println("Explanation: All are powers of 2, same prime divisor {2}");
        System.out.println();

        // Test Case 5: Different prime sets
        System.out.println("Test 5 - Different primes:");
        int[] A5 = {2, 3, 5, 7};
        int[] B5 = {3, 5, 7, 11};
        int result5 = solution.solution(A5, B5);
        System.out.println("Input: A=[2,3,5,7], B=[3,5,7,11]");
        System.out.println("Expected: 0");
        System.out.println("Got: " + result5);
        System.out.println("Explanation: No matching prime divisor sets");
        System.out.println();

        // Test Case 6: Products of same primes
        System.out.println("Test 6 - Products of {2,3}:");
        int[] A6 = {6, 12, 18};
        int[] B6 = {2, 3, 36};
        int result6 = solution.solution(A6, B6);
        System.out.println("Input: A=[6,12,18], B=[2,3,36]");
        System.out.println("Expected: 3");
        System.out.println("Got: " + result6);
        System.out.println("Explanation: 6={2,3}, 12={2,3}, 18={2,3}, 2={2}, 3={3}, 36={2,3}");
        System.out.println("All three pairs match!");
        System.out.println();

        // Test Case 7: Large numbers
        System.out.println("Test 7 - Large numbers:");
        int[] A7 = {1000000000, 999999999};
        int[] B7 = {1000000000, 999999999};
        int result7 = solution.solution(A7, B7);
        System.out.println("Input: A=[1000000000,999999999], B=[1000000000,999999999]");
        System.out.println("Expected: 2");
        System.out.println("Got: " + result7);
        System.out.println();

        // Test Case 8: One element is 1
        System.out.println("Test 8 - Mixed with 1:");
        int[] A8 = {1, 2, 1};
        int[] B8 = {2, 1, 1};
        int result8 = solution.solution(A8, B8);
        System.out.println("Input: A=[1,2,1], B=[2,1,1]");
        System.out.println("Expected: 1 (only the (1,1) pair at index 2)");
        System.out.println("Got: " + result8);
        System.out.println();

        // Test Case 9: Multiple of each other but different prime sets
        System.out.println("Test 9 - Multiples with extra primes:");
        int[] A9 = {10, 14, 21};
        int[] B9 = {30, 28, 35};
        int result9 = solution.solution(A9, B9);
        System.out.println("Input: A=[10,14,21], B=[30,28,35]");
        System.out.println("Expected: 1");
        System.out.println("Got: " + result9);
        System.out.println("Explanation: 10={2,5}, 30={2,3,5} NO; 14={2,7}, 28={2,7} YES; 21={3,7}, 35={5,7} NO");
        System.out.println();

        // Test Case 10: Prime numbers
        System.out.println("Test 10 - Prime numbers:");
        int[] A10 = {2, 3, 5, 7, 11};
        int[] B10 = {2, 3, 5, 7, 11};
        int result10 = solution.solution(A10, B10);
        System.out.println("Input: A=[2,3,5,7,11], B=[2,3,5,7,11]");
        System.out.println("Expected: 5");
        System.out.println("Got: " + result10);
        System.out.println("Explanation: Each prime only has itself as prime divisor");
        System.out.println();

        // Test Case 11: Complex case
        System.out.println("Test 11 - Complex numbers:");
        int[] A11 = {60, 120, 180};
        int[] B11 = {90, 240, 270};
        int result11 = solution.solution(A11, B11);
        System.out.println("Input: A=[60,120,180], B=[90,240,270]");
        System.out.println("Expected: 2");
        System.out.println("Got: " + result11);
        System.out.println("Explanation:");
        System.out.println("  60={2,3,5}, 90={2,3,5} YES");
        System.out.println("  120={2,3,5}, 240={2,3,5} YES");
        System.out.println("  180={2,3,5}, 270={2,3,5} YES");
        System.out.println();

        // Test Case 12: Single element array
        System.out.println("Test 12 - Single element:");
        int[] A12 = {42};
        int[] B12 = {42};
        int result12 = solution.solution(A12, B12);
        System.out.println("Input: A=[42], B=[42]");
        System.out.println("Expected: 1");
        System.out.println("Got: " + result12);
        System.out.println();
    }
}