package Java.codility;

/**
 * Ladder - Codility Lesson 13: Fibonacci Numbers
 * Difficulty: Medium
 *
 * PROBLEM DESCRIPTION:
 * You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each
 * step, you can climb up either one or two rungs at a time. More precisely, if you are on rung K,
 * you can move to either rung K+1 or K+2.
 *
 * Write a function that, given an array A and array B of L integers, returns an array consisting
 * of L integers specifying the number of different ways of climbing the ladder with A[K] rungs
 * modulo 2^B[K].
 *
 * The number of different ways can be very large, so it is sufficient to return the result modulo
 * 2^B[K] for each K.
 *
 * TASK:
 * Count the number of different ways of climbing to the top of a ladder with N rungs, for multiple
 * queries, returning each result modulo 2^B[K].
 *
 * EXAMPLES:
 * Example 1:
 * Given L = 5, A = [4, 4, 5, 5, 1], B = [3, 2, 4, 3, 1]
 *
 * Analysis:
 * - A[0]=4, B[0]=3: Ways to climb 4 rungs = 5, result = 5 mod 2^3 = 5 mod 8 = 5
 * - A[1]=4, B[1]=2: Ways to climb 4 rungs = 5, result = 5 mod 2^2 = 5 mod 4 = 1
 * - A[2]=5, B[2]=4: Ways to climb 5 rungs = 8, result = 8 mod 2^4 = 8 mod 16 = 8
 * - A[3]=5, B[3]=3: Ways to climb 5 rungs = 8, result = 8 mod 2^3 = 8 mod 8 = 0
 * - A[4]=1, B[4]=1: Ways to climb 1 rung = 1, result = 1 mod 2^1 = 1 mod 2 = 1
 *
 * Output: [5, 1, 8, 0, 1]
 *
 * Example 2:
 * N=1: Only one way: step to rung 1
 * N=2: Two ways: (1,1) or (2)
 * N=3: Three ways: (1,1,1), (1,2), (2,1)
 * N=4: Five ways: (1,1,1,1), (1,1,2), (1,2,1), (2,1,1), (2,2)
 * N=5: Eight ways: (1,1,1,1,1), (1,1,1,2), (1,1,2,1), (1,2,1,1), (2,1,1,1), (1,2,2), (2,1,2), (2,2,1)
 *
 * CONSTRAINTS:
 * - L is an integer within the range [1..50,000]
 * - Each element of array A is an integer within the range [1..L]
 * - Each element of array B is an integer within the range [1..30]
 * - Expected time complexity: O(L)
 * - Expected space complexity: O(L)
 *
 * HINTS:
 * 1. This problem is closely related to the Fibonacci sequence!
 *    Think about how you reach rung N: you can come from rung N-1 (one step) or rung N-2 (two steps).
 *    Therefore: ways(N) = ways(N-1) + ways(N-2)
 *
 * 2. Base cases:
 *    - ways(1) = 1 (only one way: take one step)
 *    - ways(2) = 2 (two ways: 1+1 or 2)
 *    - ways(3) = 3, ways(4) = 5, ways(5) = 8...
 *    This is exactly the Fibonacci sequence! ways(N) = Fib(N+1)
 *
 * 3. Since you need to handle multiple queries and the maximum value in A is L, you should
 *    precompute all Fibonacci numbers (ladder ways) up to L once.
 *
 * 4. Modulo arithmetic optimization:
 *    - The maximum B[K] is 30, so the maximum modulo is 2^30 = 1,073,741,824
 *    - You can compute all Fibonacci numbers modulo 2^30 in advance
 *    - When answering each query, just mask the result with (2^B[K] - 1)
 *    - Or use: result & ((1 << B[K]) - 1)
 *
 * 5. Why modulo 2^B works well:
 *    - 2^B - 1 in binary is all 1s (e.g., 2^3 - 1 = 7 = 111 in binary)
 *    - Using bitwise AND with (2^B - 1) is equivalent to taking modulo 2^B
 *    - This is faster than using the % operator
 *
 * 6. Algorithm outline:
 *    a) Precompute Fibonacci numbers up to max(A) + 1, storing each modulo 2^30
 *    b) For each query K:
 *       - Get the precomputed Fibonacci value for A[K]+1
 *       - Apply modulo 2^B[K] using bitwise operation: fib[A[K]+1] & ((1 << B[K]) - 1)
 *
 * 7. Edge cases:
 *    - A[K] = 1: ways(1) = 1
 *    - B[K] = 1: only consider last bit (result is 0 or 1)
 *    - Large L (up to 50,000): must be efficient
 *
 * 8. Mathematical insight:
 *    - The number of ways to climb N rungs follows: 1, 2, 3, 5, 8, 13, 21, 34...
 *    - This is Fibonacci starting from F(2) = 1, F(3) = 2
 *    - Or equivalently: ways(N) = F(N+1) where F is standard Fibonacci with F(0)=0, F(1)=1
 *
 * SOLUTION APPROACH:
 * 1. Create a Fibonacci array of size L+2 (to handle max A value)
 * 2. Fill the array with Fibonacci numbers modulo 2^30
 * 3. For each query, return fib[A[K]+1] & ((1 << B[K]) - 1)
 */
public class Ladder {

    // TODO: Implement your solution here
    public int[] solution(int[] A, int[] B) {
        // Your code goes here
        int[] result = new int[A.length];
        return result;
    }

    // ==================== TEST CASES ====================

    public static void main(String[] args) {
        Ladder solution = new Ladder();

        // Test Case 1: Example from problem
        System.out.println("Test 1 - Example from problem:");
        int[] A1 = {4, 4, 5, 5, 1};
        int[] B1 = {3, 2, 4, 3, 1};
        int[] result1 = solution.solution(A1, B1);
        System.out.println("Input: A=[4,4,5,5,1], B=[3,2,4,3,1]");
        System.out.println("Expected: [5,1,8,0,1]");
        System.out.print("Got: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + (i < result1.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Explanation:");
        System.out.println("  4 rungs: 5 ways. 5 mod 8=5, 5 mod 4=1");
        System.out.println("  5 rungs: 8 ways. 8 mod 16=8, 8 mod 8=0");
        System.out.println("  1 rung: 1 way. 1 mod 2=1");
        System.out.println();

        // Test Case 2: Small values
        System.out.println("Test 2 - Small rungs:");
        int[] A2 = {1, 2, 3};
        int[] B2 = {1, 2, 3};
        int[] result2 = solution.solution(A2, B2);
        System.out.println("Input: A=[1,2,3], B=[1,2,3]");
        System.out.println("Expected: [1,2,3]");
        System.out.print("Got: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + (i < result2.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Explanation: 1 way, 2 ways, 3 ways respectively");
        System.out.println();

        // Test Case 3: All same A, different B
        System.out.println("Test 3 - Same rungs, different modulo:");
        int[] A3 = {10, 10, 10, 10};
        int[] B3 = {1, 2, 3, 4};
        int[] result3 = solution.solution(A3, B3);
        System.out.println("Input: A=[10,10,10,10], B=[1,2,3,4]");
        System.out.println("10 rungs = 89 ways (Fibonacci number)");
        System.out.println("Expected: [89 mod 2, 89 mod 4, 89 mod 8, 89 mod 16]");
        System.out.println("         = [1, 1, 1, 9]");
        System.out.print("Got: [");
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + (i < result3.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println();

        // Test Case 4: Powers of 2 modulo
        System.out.println("Test 4 - Powers of 2:");
        int[] A4 = {6, 7, 8};
        int[] B4 = {4, 4, 4};
        int[] result4 = solution.solution(A4, B4);
        System.out.println("Input: A=[6,7,8], B=[4,4,4]");
        System.out.println("6 rungs = 13 ways, 7 rungs = 21 ways, 8 rungs = 34 ways");
        System.out.println("Expected: [13 mod 16, 21 mod 16, 34 mod 16] = [13, 5, 2]");
        System.out.print("Got: [");
        for (int i = 0; i < result4.length; i++) {
            System.out.print(result4[i] + (i < result4.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println();

        // Test Case 5: Large rungs
        System.out.println("Test 5 - Large rungs:");
        int[] A5 = {50, 100, 200};
        int[] B5 = {10, 15, 20};
        int[] result5 = solution.solution(A5, B5);
        System.out.println("Input: A=[50,100,200], B=[10,15,20]");
        System.out.println("Expected: [some large Fibonacci numbers modulo 2^10, 2^15, 2^20]");
        System.out.print("Got: [");
        for (int i = 0; i < result5.length; i++) {
            System.out.print(result5[i] + (i < result5.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println();

        // Test Case 6: B=1 (only care about odd/even)
        System.out.println("Test 6 - B=1 (odd/even only):");
        int[] A6 = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] B6 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] result6 = solution.solution(A6, B6);
        System.out.println("Input: A=[2,3,4,5,6,7,8,9,10], B=[1,1,1,1,1,1,1,1,1]");
        System.out.println("Ways: 2,3,5,8,13,21,34,55,89 -> mod 2: even/odd");
        System.out.println("Expected: [0,1,1,0,1,1,0,1,1]");
        System.out.print("Got: [");
        for (int i = 0; i < result6.length; i++) {
            System.out.print(result6[i] + (i < result6.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println();

        // Test Case 7: Maximum B value
        System.out.println("Test 7 - Maximum B (B=30):");
        int[] A7 = {5, 10, 15};
        int[] B7 = {30, 30, 30};
        int[] result7 = solution.solution(A7, B7);
        System.out.println("Input: A=[5,10,15], B=[30,30,30]");
        System.out.println("Expected: [8, 89, 987] (full Fibonacci values, no truncation)");
        System.out.print("Got: [");
        for (int i = 0; i < result7.length; i++) {
            System.out.print(result7[i] + (i < result7.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println();

        // Test Case 8: Single element
        System.out.println("Test 8 - Single element:");
        int[] A8 = {1};
        int[] B8 = {1};
        int[] result8 = solution.solution(A8, B8);
        System.out.println("Input: A=[1], B=[1]");
        System.out.println("Expected: [1]");
        System.out.print("Got: [");
        for (int i = 0; i < result8.length; i++) {
            System.out.print(result8[i] + (i < result8.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println();

        // Test Case 9: All maximum values
        System.out.println("Test 9 - Large L:");
        int L = 1000;
        int[] A9 = new int[L];
        int[] B9 = new int[L];
        for (int i = 0; i < L; i++) {
            A9[i] = i + 1;
            B9[i] = (i % 30) + 1;
        }
        long startTime = System.currentTimeMillis();
        int[] result9 = solution.solution(A9, B9);
        long endTime = System.currentTimeMillis();
        System.out.println("Input: L=1000, A[i]=i+1, B[i]=(i%30)+1");
        System.out.println("Expected: Various Fibonacci results");
        System.out.println("First 5 results: [" + result9[0] + "," + result9[1] + ","
                          + result9[2] + "," + result9[3] + "," + result9[4] + "]");
        System.out.println("Time: " + (endTime - startTime) + "ms");
        System.out.println();

        // Test Case 10: Fibonacci verification
        System.out.println("Test 10 - Fibonacci sequence verification:");
        int[] A10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] B10 = {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        int[] result10 = solution.solution(A10, B10);
        System.out.println("Input: A=[1..12], B=[30..30]");
        System.out.println("Expected Fibonacci: [1,2,3,5,8,13,21,34,55,89,144,233]");
        System.out.print("Got: [");
        for (int i = 0; i < result10.length; i++) {
            System.out.print(result10[i] + (i < result10.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println();

        // Test Case 11: Modulo pattern
        System.out.println("Test 11 - Modulo pattern:");
        int[] A11 = {20, 20, 20, 20, 20};
        int[] B11 = {1, 2, 3, 4, 5};
        int[] result11 = solution.solution(A11, B11);
        System.out.println("Input: A=[20,20,20,20,20], B=[1,2,3,4,5]");
        System.out.println("20 rungs = 10946 ways");
        System.out.println("Expected: [10946 mod 2, 4, 8, 16, 32] = [0, 2, 2, 2, 2]");
        System.out.print("Got: [");
        for (int i = 0; i < result11.length; i++) {
            System.out.print(result11[i] + (i < result11.length - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println();
    }
}
