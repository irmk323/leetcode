package Java.codility;

import java.util.*;

/**
 * NailingPlanks - Codility Lesson 14: Binary Search Algorithm
 * Difficulty: Hard
 *
 * PROBLEM DESCRIPTION:
 * You are given two non-empty arrays A and B consisting of N integers. These arrays represent
 * N planks. More precisely, A[K] is the start and B[K] is the end of the K-th plank.
 *
 * Next, you are given a non-empty array C consisting of M integers. This array represents M nails.
 * More precisely, C[I] is the position where you can hammer in the I-th nail.
 *
 * We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].
 *
 * The goal is to find the minimum number of nails that must be used until all the planks are nailed.
 * In other words, you should find a value J such that all planks will be nailed after using only
 * the first J nails (nails C[0], C[1], ..., C[J-1]).
 *
 * TASK:
 * Write a function that, given two non-empty arrays A and B consisting of N integers and a non-empty
 * array C consisting of M integers, returns the minimum number of nails needed to nail all the planks.
 * If it is not possible to nail all the planks, the function should return -1.
 *
 * EXAMPLES:
 * Example 1:
 * Input:
 * - A = [1, 4, 5, 8]    (plank start positions)
 * - B = [4, 5, 9, 10]   (plank end positions)
 * - C = [4, 6, 7, 10, 2] (nail positions)
 *
 * Planks:
 * - Plank 0: [1, 4]
 * - Plank 1: [4, 5]
 * - Plank 2: [5, 9]
 * - Plank 3: [8, 10]
 *
 * Analysis:
 * - Using nails C[0..0] = [4]: Planks 0,1 nailed. Planks 2,3 not nailed.
 * - Using nails C[0..1] = [4,6]: Planks 0,1,2 nailed. Plank 3 not nailed.
 * - Using nails C[0..2] = [4,6,7]: Planks 0,1,2 nailed. Plank 3 not nailed.
 * - Using nails C[0..3] = [4,6,7,10]: All planks nailed!
 *   - Plank 0: nailed by C[0]=4
 *   - Plank 1: nailed by C[0]=4
 *   - Plank 2: nailed by C[1]=6 or C[2]=7
 *   - Plank 3: nailed by C[3]=10
 *
 * Output: 4
 *
 * Example 2:
 * Input: A = [1], B = [5], C = [2, 3]
 * Plank [1,5] can be nailed by C[0]=2 (or C[1]=3)
 * Output: 1
 *
 * Example 3:
 * Input: A = [1, 2], B = [3, 4], C = [5, 6]
 * No nail can hit planks [1,3] or [2,4]
 * Output: -1
 *
 * CONSTRAINTS:
 * - N and M are integers within the range [1..30,000]
 * - Each element of arrays A, B and C is an integer within the range [1..2*M]
 * - A[K] ≤ B[K] for all K
 * - Expected time complexity: O((N + M) * log(M))
 * - Expected space complexity: O(M)
 *
 * HINTS:
 * 1. This is a "Binary Search on Answer" problem. We binary search on the number of nails needed (J).
 *    For each candidate J, check if using the first J nails is sufficient to nail all planks.
 *
 * 2. Binary search bounds:
 *    - Lower bound: 1 (minimum nails needed)
 *    - Upper bound: M (maximum nails available)
 *
 * 3. For each candidate J, we need to efficiently check if all planks can be nailed using
 *    only nails C[0..J-1]. A naive O(N*J) check will be too slow.
 *
 * 4. Optimization for checking: Use a data structure to quickly query "is there any nail in range [A[K], B[K]]?"
 *    Options include:
 *    - Prefix sum array
 *    - Segment tree
 *    - Range minimum query (RMQ)
 *
 * 5. Prefix sum approach:
 *    - For a given J, create an array marking positions where nails C[0..J-1] are located
 *    - Build prefix sum array to quickly check if range [A[K], B[K]] contains any nail
 *    - If prefixSum[B[K]] - prefixSum[A[K]-1] > 0, the plank is nailed
 *
 * 6. Range Minimum Query (RMQ) approach:
 *    - For each nail position, track the earliest nail index that can hit it
 *    - For each plank [A[K], B[K]], find the minimum nail index in that range
 *    - If min nail index ≤ J, the plank is nailed
 *
 * 7. Optimized approach using "earliest nail" array:
 *    - Create an array 'earliest' where earliest[pos] = minimum index i such that C[i] = pos
 *    - For each plank, find the minimum value in earliest[A[K]..B[K]]
 *    - Use RMQ data structure (like Segment Tree) to query range minimum efficiently
 *
 * 8. Algorithm outline:
 *    a) Preprocess: For each position, store the earliest nail index that hits it
 *    b) Binary search on J (number of nails):
 *       - For each mid value:
 *         - Check if all planks can be nailed using first mid nails
 *         - For each plank, query if there exists a nail in range with index < mid
 *       - If yes, try smaller J (search left)
 *       - If no, need more nails (search right)
 *    c) Return the minimal J that works, or -1 if impossible
 *
 * 9. Alternative simpler approach (may be slower but easier):
 *    - Binary search on J
 *    - For each J, create a set of available nail positions from C[0..J-1]
 *    - For each plank, check if any nail position falls in [A[K], B[K]]
 *    - This is O(N * M * log(M)) which might pass given small constraints
 *
 * 10. Edge cases:
 *     - Single plank, single nail
 *     - No nail can hit some plank → return -1
 *     - Multiple nails at same position
 *     - All planks nailed by first nail → return 1
 *
 * 11. Time complexity analysis:
 *     - Binary search: O(log M)
 *     - Each check with RMQ: O(N * log(2M)) for building + O(N * log(2M)) for queries
 *     - Total: O((N + M) * log(M) * log(M)) or O((N + M) * log²(M))
 *     - With optimized RMQ: O((N + M) * log(M))
 *
 * SOLUTION APPROACH:
 * 1. Binary search on the answer (number of nails J)
 * 2. For each candidate, check if all planks can be nailed
 * 3. Use efficient data structure (prefix sum or RMQ) for range queries
 */
public class NailingPlanks {

    // TODO: Implement your solution here
    public int solution(int[] A, int[] B, int[] C) {
        // Your code goes here
        return -1;
    }

    /**
     * Helper function: Check if all planks can be nailed using first J nails
     */
    private boolean canNailAll(int[] A, int[] B, int[] C, int J) {
        // Mark positions where nails are placed
        int maxPos = 2 * C.length;
        int[] nailed = new int[maxPos + 1];

        for (int i = 0; i < J; i++) {
            if (C[i] <= maxPos) {
                nailed[C[i]] = 1;
            }
        }

        // Build prefix sum
        int[] prefixSum = new int[maxPos + 1];
        for (int i = 1; i <= maxPos; i++) {
            prefixSum[i] = prefixSum[i - 1] + nailed[i];
        }

        // Check each plank
        for (int k = 0; k < A.length; k++) {
            int start = A[k];
            int end = B[k];
            if (prefixSum[end] - prefixSum[start - 1] == 0) {
                return false;  // This plank is not nailed
            }
        }

        return true;
    }

    // ==================== TEST CASES ====================

    public static void main(String[] args) {
        NailingPlanks solution = new NailingPlanks();

        // Test Case 1: Example from problem
        System.out.println("Test 1 - Example from problem:");
        int[] A1 = {1, 4, 5, 8};
        int[] B1 = {4, 5, 9, 10};
        int[] C1 = {4, 6, 7, 10, 2};
        int result1 = solution.solution(A1, B1, C1);
        System.out.println("Input:");
        System.out.println("  Planks: [1,4], [4,5], [5,9], [8,10]");
        System.out.println("  Nails: [4, 6, 7, 10, 2]");
        System.out.println("Expected: 4");
        System.out.println("Got: " + result1);
        System.out.println("Using nails at positions 4,6,7,10 nails all planks");
        System.out.println();

        // Test Case 2: Single plank, single nail
        System.out.println("Test 2 - Single plank and nail:");
        int[] A2 = {1};
        int[] B2 = {5};
        int[] C2 = {3};
        int result2 = solution.solution(A2, B2, C2);
        System.out.println("Input: Plank [1,5], Nail at 3");
        System.out.println("Expected: 1");
        System.out.println("Got: " + result2);
        System.out.println();

        // Test Case 3: Impossible case
        System.out.println("Test 3 - Impossible:");
        int[] A3 = {1, 2};
        int[] B3 = {3, 4};
        int[] C3 = {5, 6};
        int result3 = solution.solution(A3, B3, C3);
        System.out.println("Input: Planks [1,3], [2,4]; Nails at 5,6");
        System.out.println("Expected: -1");
        System.out.println("Got: " + result3);
        System.out.println();

        // Test Case 4: First nail nails all
        System.out.println("Test 4 - First nail sufficient:");
        int[] A4 = {1, 2, 3};
        int[] B4 = {5, 5, 5};
        int[] C4 = {4, 6, 7};
        int result4 = solution.solution(A4, B4, C4);
        System.out.println("Input: All planks contain position 4");
        System.out.println("Expected: 1");
        System.out.println("Got: " + result4);
        System.out.println();

        // Test Case 5: Need all nails
        System.out.println("Test 5 - Need all nails:");
        int[] A5 = {1, 3, 5, 7};
        int[] B5 = {2, 4, 6, 8};
        int[] C5 = {1, 3, 5, 7};
        int result5 = solution.solution(A5, B5, C5);
        System.out.println("Input: Each plank needs specific nail");
        System.out.println("Expected: 4");
        System.out.println("Got: " + result5);
        System.out.println();

        // Test Case 6: Overlapping planks
        System.out.println("Test 6 - Overlapping planks:");
        int[] A6 = {1, 1, 1};
        int[] B6 = {10, 10, 10};
        int[] C6 = {5};
        int result6 = solution.solution(A6, B6, C6);
        System.out.println("Input: Three identical planks [1,10], nail at 5");
        System.out.println("Expected: 1");
        System.out.println("Got: " + result6);
        System.out.println();

        // Test Case 7: Nails at boundaries
        System.out.println("Test 7 - Boundary nails:");
        int[] A7 = {1, 5, 10};
        int[] B7 = {3, 7, 12};
        int[] C7 = {1, 5, 10, 15};
        int result7 = solution.solution(A7, B7, C7);
        System.out.println("Input: Nails at plank start positions");
        System.out.println("Expected: 3");
        System.out.println("Got: " + result7);
        System.out.println();

        // Test Case 8: Duplicate nail positions
        System.out.println("Test 8 - Duplicate nails:");
        int[] A8 = {1, 4};
        int[] B8 = {3, 6};
        int[] C8 = {2, 2, 2, 5, 5};
        int result8 = solution.solution(A8, B8, C8);
        System.out.println("Input: Multiple nails at same positions");
        System.out.println("Expected: 4 (need nail at position 5 which is C[3])");
        System.out.println("Got: " + result8);
        System.out.println();

        // Test Case 9: Long planks
        System.out.println("Test 9 - Very long planks:");
        int[] A9 = {1, 1};
        int[] B9 = {1000, 1000};
        int[] C9 = {500, 999, 1, 1000};
        int result9 = solution.solution(A9, B9, C9);
        System.out.println("Input: Long planks, multiple nail options");
        System.out.println("Expected: 1 (first nail at 500 hits both)");
        System.out.println("Got: " + result9);
        System.out.println();

        // Test Case 10: Sequential planks
        System.out.println("Test 10 - Sequential planks:");
        int[] A10 = {1, 2, 3, 4, 5};
        int[] B10 = {1, 2, 3, 4, 5};
        int[] C10 = {1, 2, 3, 4, 5};
        int result10 = solution.solution(A10, B10, C10);
        System.out.println("Input: Each plank is single position");
        System.out.println("Expected: 5");
        System.out.println("Got: " + result10);
        System.out.println();

        // Test Case 11: Nails in reverse order
        System.out.println("Test 11 - Reverse order nails:");
        int[] A11 = {1, 3, 5};
        int[] B11 = {2, 4, 6};
        int[] C11 = {6, 4, 2};
        int result11 = solution.solution(A11, B11, C11);
        System.out.println("Input: Nails appear in reverse order");
        System.out.println("Expected: 3 (need all three)");
        System.out.println("Got: " + result11);
        System.out.println();

        // Test Case 12: Large gaps
        System.out.println("Test 12 - Large gaps:");
        int[] A12 = {1, 1000, 2000};
        int[] B12 = {10, 1100, 2100};
        int[] C12 = {5, 1050, 2050, 3000};
        int result12 = solution.solution(A12, B12, C12);
        System.out.println("Input: Planks with large gaps");
        System.out.println("Expected: 3");
        System.out.println("Got: " + result12);
        System.out.println();

        // Test Case 13: Maximum size test
        System.out.println("Test 13 - Larger test:");
        int n = 100;
        int[] A13 = new int[n];
        int[] B13 = new int[n];
        int[] C13 = new int[n * 2];
        for (int i = 0; i < n; i++) {
            A13[i] = i * 2 + 1;
            B13[i] = i * 2 + 2;
            C13[i] = i * 2 + 1;
            C13[i + n] = i * 2 + 2;
        }
        long startTime = System.currentTimeMillis();
        int result13 = solution.solution(A13, B13, C13);
        long endTime = System.currentTimeMillis();
        System.out.println("Input: 100 planks, 200 nails");
        System.out.println("Expected: ≤ 100");
        System.out.println("Got: " + result13);
        System.out.println("Time: " + (endTime - startTime) + "ms");
        System.out.println();

        // Test Case 14: One plank needs last nail
        System.out.println("Test 14 - Last nail needed:");
        int[] A14 = {1, 2, 3, 4};
        int[] B14 = {1, 2, 3, 10};
        int[] C14 = {1, 2, 3, 10};
        int result14 = solution.solution(A14, B14, C14);
        System.out.println("Input: Last plank needs last nail");
        System.out.println("Expected: 4");
        System.out.println("Got: " + result14);
        System.out.println();
    }
}
