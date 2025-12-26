package Java.codility;

/**
 * MinMaxDivision - Codility Lesson 14: Binary Search Algorithm
 * Difficulty: Medium
 *
 * PROBLEM DESCRIPTION:
 * You are given integers K, M and a non-empty array A consisting of N integers.
 * Every element of the array is not greater than M.
 *
 * You should divide this array into K blocks of consecutive elements.
 * The size of the block is any integer between 0 and N. Every element of the array should belong
 * to some block.
 *
 * The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y].
 * The sum of empty block equals 0.
 *
 * The large sum is the maximal sum of any block.
 *
 * TASK:
 * Write a function that, given integers K, M and a non-empty array A consisting of N integers,
 * returns the minimal large sum.
 *
 * In other words, you need to minimize the maximum sum among all K blocks.
 *
 * EXAMPLES:
 * Example 1:
 * Input: K = 3, M = 5, A = [2, 1, 5, 1, 2, 2, 2]
 * Analysis:
 * One possible division:
 * - Block 1: [2, 1] → sum = 3
 * - Block 2: [5, 1] → sum = 6
 * - Block 3: [2, 2, 2] → sum = 6
 * Large sum = max(3, 6, 6) = 6
 *
 * This is optimal. Other divisions yield larger maximum sums:
 * - [2, 1, 5], [1], [2, 2, 2] → max(8, 1, 6) = 8
 * - [2], [1, 5, 1, 2], [2, 2] → max(2, 9, 4) = 9
 *
 * Output: 6
 *
 * Example 2:
 * Input: K = 1, M = 10, A = [5, 3, 2]
 * Can't divide into blocks, so large sum = 5 + 3 + 2 = 10
 * Output: 10
 *
 * Example 3:
 * Input: K = 3, M = 10, A = [5, 3, 2]
 * Best division: [5], [3], [2] → max(5, 3, 2) = 5
 * Output: 5
 *
 * CONSTRAINTS:
 * - N and K are integers within the range [1..100,000]
 * - M is an integer within the range [0..10,000]
 * - Each element of array A is an integer within the range [0..M]
 * - Expected time complexity: O(N * log(N + M))
 * - Expected space complexity: O(1)
 *
 * HINTS:
 * 1. This is a classic "Binary Search on Answer" problem. Instead of finding the optimal division
 *    directly, we binary search for the minimal possible "large sum" value.
 *
 * 2. Key insight: If we can divide the array into K blocks with maximum sum ≤ X, then we can also
 *    do it with maximum sum ≤ Y for any Y > X. This monotonic property allows binary search.
 *
 * 3. Binary search bounds:
 *    - Lower bound: max(A) - We must at least accommodate the largest element
 *    - Upper bound: sum(A) - Worst case is putting everything in one block
 *
 * 4. For each candidate value 'mid' in binary search, check if it's possible to divide the array
 *    into K or fewer blocks where each block's sum ≤ mid.
 *
 * 5. Validation function (greedy approach):
 *    - Iterate through array, keeping a running sum for current block
 *    - When adding next element would exceed 'mid', start a new block
 *    - Count total blocks needed
 *    - Return true if blocks needed ≤ K
 *
 * 6. Algorithm outline:
 *    a) Calculate lower bound (max element) and upper bound (total sum)
 *    b) Binary search in range [lower, upper]:
 *       - For each mid value, check if division is possible
 *       - If possible with mid, try smaller (search left)
 *       - If not possible, must increase (search right)
 *    c) Return the minimal valid mid value
 *
 * 7. Example walkthrough with K=3, A=[2,1,5,1,2,2,2]:
 *    - Lower = 5 (max element), Upper = 15 (sum)
 *    - Try mid = 10: Can we divide into ≤3 blocks with max sum ≤10?
 *      [2,1,5,1] (sum=9), [2,2,2] (sum=6) → 2 blocks ✓ → try smaller
 *    - Try mid = 7: [2,1,5] (sum=8) → Already exceeded! Actually [2,1] (sum=3), [5,1] (sum=6), [2,2,2] (sum=6) → 3 blocks ✓
 *    - Try mid = 6: [2,1] (sum=3), [5,1] (sum=6), [2,2,2] (sum=6) → 3 blocks ✓
 *    - Try mid = 5: [2,1] (sum=3), [5] (sum=5), [1,2,2] (sum=5), [2] (sum=2) → 4 blocks ✗
 *    - Answer: 6
 *
 * 8. Edge cases:
 *    - K = 1: Answer is sum of all elements
 *    - K ≥ N: Each element can be in its own block, answer is max element
 *    - All elements equal: Answer depends on how many fit in K blocks
 *
 * 9. Time complexity analysis:
 *    - Binary search runs O(log(sum(A) - max(A))) ≈ O(log(N*M)) times
 *    - Each validation takes O(N)
 *    - Total: O(N * log(N*M))
 *
 * SOLUTION APPROACH:
 * 1. Binary search on the answer (the minimal large sum)
 * 2. For each candidate, use greedy algorithm to check if it's achievable
 * 3. Narrow the search range based on feasibility
 */
public class MinMaxDivision {

    // TODO: Implement your solution here
    public int solution(int K, int M, int[] A) {
        // Your code goes here
        return 0;
    }

    /**
     * Helper function: Check if array can be divided into ≤ K blocks
     * where each block sum is ≤ maxSum
     */
    private boolean canDivide(int[] A, int K, int maxSum) {
        int blocks = 1;
        int currentSum = 0;

        for (int value : A) {
            if (currentSum + value > maxSum) {
                blocks++;
                currentSum = value;
                if (blocks > K) {
                    return false;
                }
            } else {
                currentSum += value;
            }
        }

        return true;
    }

    // ==================== TEST CASES ====================

    public static void main(String[] args) {
        MinMaxDivision solution = new MinMaxDivision();

        // Test Case 1: Example from problem
        System.out.println("Test 1 - Example from problem:");
        int[] A1 = {2, 1, 5, 1, 2, 2, 2};
        int result1 = solution.solution(3, 5, A1);
        System.out.println("Input: K=3, M=5, A=[2,1,5,1,2,2,2]");
        System.out.println("Expected: 6");
        System.out.println("Got: " + result1);
        System.out.println("Division: [2,1] | [5,1] | [2,2,2] with sums [3,6,6]");
        System.out.println();

        // Test Case 2: K = 1 (no division)
        System.out.println("Test 2 - K=1 (no division):");
        int[] A2 = {5, 3, 2};
        int result2 = solution.solution(1, 10, A2);
        System.out.println("Input: K=1, M=10, A=[5,3,2]");
        System.out.println("Expected: 10 (sum of all)");
        System.out.println("Got: " + result2);
        System.out.println();

        // Test Case 3: K >= N (each element separate)
        System.out.println("Test 3 - K>=N (max element):");
        int[] A3 = {5, 3, 2};
        int result3 = solution.solution(3, 10, A3);
        System.out.println("Input: K=3, M=10, A=[5,3,2]");
        System.out.println("Expected: 5 (max element)");
        System.out.println("Got: " + result3);
        System.out.println("Division: [5] | [3] | [2]");
        System.out.println();

        // Test Case 4: K > N
        System.out.println("Test 4 - K>N (more blocks than elements):");
        int[] A4 = {5, 3, 2};
        int result4 = solution.solution(5, 10, A4);
        System.out.println("Input: K=5, M=10, A=[5,3,2]");
        System.out.println("Expected: 5 (max element)");
        System.out.println("Got: " + result4);
        System.out.println("Extra blocks are empty");
        System.out.println();

        // Test Case 5: All elements equal
        System.out.println("Test 5 - All equal elements:");
        int[] A5 = {3, 3, 3, 3, 3, 3};
        int result5 = solution.solution(2, 3, A5);
        System.out.println("Input: K=2, M=3, A=[3,3,3,3,3,3]");
        System.out.println("Expected: 9");
        System.out.println("Got: " + result5);
        System.out.println("Division: [3,3,3] | [3,3,3]");
        System.out.println();

        // Test Case 6: Single element
        System.out.println("Test 6 - Single element:");
        int[] A6 = {10};
        int result6 = solution.solution(1, 10, A6);
        System.out.println("Input: K=1, M=10, A=[10]");
        System.out.println("Expected: 10");
        System.out.println("Got: " + result6);
        System.out.println();

        // Test Case 7: Large numbers
        System.out.println("Test 7 - Large array:");
        int[] A7 = new int[100];
        for (int i = 0; i < 100; i++) {
            A7[i] = i % 10 + 1;  // Values 1-10 repeating
        }
        int result7 = solution.solution(10, 10, A7);
        System.out.println("Input: K=10, M=10, A=[100 elements with values 1-10]");
        System.out.println("Expected: Around 50-55");
        System.out.println("Got: " + result7);
        System.out.println();

        // Test Case 8: Two blocks, ascending values
        System.out.println("Test 8 - Ascending values:");
        int[] A8 = {1, 2, 3, 4, 5};
        int result8 = solution.solution(2, 5, A8);
        System.out.println("Input: K=2, M=5, A=[1,2,3,4,5]");
        System.out.println("Expected: 9");
        System.out.println("Got: " + result8);
        System.out.println("Division: [1,2,3,4] | [5] → max(10,5)=10 NO");
        System.out.println("Division: [1,2,3] | [4,5] → max(6,9)=9 YES");
        System.out.println();

        // Test Case 9: Many blocks
        System.out.println("Test 9 - Many blocks:");
        int[] A9 = {1, 1, 1, 1, 1, 1, 1, 1};
        int result9 = solution.solution(4, 1, A9);
        System.out.println("Input: K=4, M=1, A=[1,1,1,1,1,1,1,1]");
        System.out.println("Expected: 2");
        System.out.println("Got: " + result9);
        System.out.println("Division: [1,1] | [1,1] | [1,1] | [1,1]");
        System.out.println();

        // Test Case 10: Zeros in array
        System.out.println("Test 10 - With zeros:");
        int[] A10 = {0, 0, 5, 0, 0};
        int result10 = solution.solution(2, 5, A10);
        System.out.println("Input: K=2, M=5, A=[0,0,5,0,0]");
        System.out.println("Expected: 5");
        System.out.println("Got: " + result10);
        System.out.println("Division: [0,0,5] | [0,0] or [0,0] | [5,0,0]");
        System.out.println();

        // Test Case 11: Maximum M value
        System.out.println("Test 11 - Maximum M:");
        int[] A11 = {10000, 10000, 10000};
        int result11 = solution.solution(2, 10000, A11);
        System.out.println("Input: K=2, M=10000, A=[10000,10000,10000]");
        System.out.println("Expected: 20000");
        System.out.println("Got: " + result11);
        System.out.println("Division: [10000,10000] | [10000]");
        System.out.println();

        // Test Case 12: Alternating high-low
        System.out.println("Test 12 - Alternating values:");
        int[] A12 = {5, 1, 5, 1, 5, 1};
        int result12 = solution.solution(3, 5, A12);
        System.out.println("Input: K=3, M=5, A=[5,1,5,1,5,1]");
        System.out.println("Expected: 6");
        System.out.println("Got: " + result12);
        System.out.println("Division: [5,1] | [5,1] | [5,1]");
        System.out.println();

        // Test Case 13: One large element
        System.out.println("Test 13 - One dominant element:");
        int[] A13 = {1, 1, 1, 10, 1, 1, 1};
        int result13 = solution.solution(3, 10, A13);
        System.out.println("Input: K=3, M=10, A=[1,1,1,10,1,1,1]");
        System.out.println("Expected: 10");
        System.out.println("Got: " + result13);
        System.out.println("Division: [1,1,1] | [10] | [1,1,1]");
        System.out.println();

        // Test Case 14: Performance test
        System.out.println("Test 14 - Large performance test:");
        int[] A14 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            A14[i] = (i % 100) + 1;
        }
        long startTime = System.currentTimeMillis();
        int result14 = solution.solution(1000, 100, A14);
        long endTime = System.currentTimeMillis();
        System.out.println("Input: K=1000, M=100, A=[100000 elements]");
        System.out.println("Got: " + result14);
        System.out.println("Time: " + (endTime - startTime) + "ms");
        System.out.println();
    }
}
