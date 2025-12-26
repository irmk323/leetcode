package Java.codility;

import java.util.*;

/**
 * FibFrog - Codility Lesson 13: Fibonacci Numbers
 * Difficulty: Hard
 *
 * PROBLEM DESCRIPTION:
 * The Fibonacci sequence is defined as follows:
 * - F(0) = 0
 * - F(1) = 1
 * - F(M) = F(M-1) + F(M-2) for M >= 2
 *
 * A small frog wants to get to the other side of a river. The frog is initially located at one bank
 * of the river (position -1) and wants to get to the other bank (position N).
 *
 * The frog can jump over any distance F(K), where F(K) is a Fibonacci number. Luckily, there are
 * many leaves on the river, and the frog can jump between leaves, but only in the direction of the
 * other bank.
 *
 * The leaves on the river are represented by an array A consisting of N integers. Consecutive
 * elements of array A represent consecutive positions from 0 to N-1 on the river. Array A contains
 * only 0s and/or 1s:
 * - 0 represents a position without a leaf
 * - 1 represents a position with a leaf
 *
 * The goal is to count the minimum number of jumps in which the frog can get to the other side
 * of the river (position N). The frog can jump between positions -1 and N (the banks of the river)
 * and every position containing a leaf (value 1).
 *
 * TASK:
 * Write a function that, given an array A consisting of N integers, returns the minimum number of
 * jumps by which the frog can get to the other side of the river. If the frog cannot reach the
 * other side, return -1.
 *
 * EXAMPLES:`
 * Example 1:
 * Input: A = [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0]
 * Positions:  0  1  2  3  4  5  6  7  8  9  10
 * Bank (-1) ---> N (11)
 *
 * Solution path:
 * - Start at position -1
 * - Jump F(5) = 5 to position 4 (has leaf)
 * - Jump F(3) = 2 to position 6 (has leaf)
 * - Jump F(5) = 5 to position 11 (goal!)
 * Output: 3
 *
 * Example 2:
 * Input: A = [1, 1, 1, 1, 1]
 * Can jump F(2)=1 five times, or F(3)=2 then F(4)=3, etc.
 * Output: Varies (multiple solutions possible)
 *
 * Example 3:
 * Input: A = [0, 0, 0]
 * Cannot reach position 3 from -1 with any Fibonacci jump
 * Output: -1
 *
 * CONSTRAINTS:
 * - N is an integer within the range [0..100,000]
 * - Each element of array A is an integer that can have one of the following values: 0, 1
 * - Expected time complexity: O(N * log(N))
 * - Expected space complexity: O(N)
 *
 * HINTS:
 * 1. This is a shortest path problem. Consider using BFS (Breadth-First Search) to find the
 *    minimum number of jumps. BFS guarantees finding the shortest path in unweighted graphs.
 *
 * 2. Precompute all Fibonacci numbers up to N+1. Since Fibonacci grows exponentially, there
 *    won't be many of them (about log(N) Fibonacci numbers).
 *
 * 3. The Fibonacci sequence grows quickly:
 *    F(1)=1, F(2)=1, F(3)=2, F(4)=3, F(5)=5, F(6)=8, F(7)=13, F(8)=21, F(9)=34, F(10)=55,
 *    F(11)=89, F(12)=144, F(13)=233, F(14)=377, F(15)=610, F(16)=987, F(17)=1597...
 *    For N=100,000, you only need about 26 Fibonacci numbers.
 *
 * 4. BFS approach:
 *    - Start from position -1
 *    - Use a queue to store (position, jumps) pairs
 *    - For each position, try all possible Fibonacci jumps
 *    - Only jump to positions with leaves (A[pos]=1) or the final position (N)
 *    - Mark visited positions to avoid revisiting
 *    - Return the number of jumps when reaching position N
 *
 * 5. State representation:
 *    - Current position: -1 to N
 *    - Number of jumps taken so far
 *    - Visited positions (to avoid cycles)
 *
 * 6. Optimization: Instead of checking all positions, only try jumps to positions that have leaves
 *    or the goal position.
 *
 * 7. Edge cases:
 *    - N = 0: Already at the other side, return 0
 *    - Can jump directly from -1 to N if N is a Fibonacci number
 *    - No path exists: return -1
 *
 * 8. Alternative approach (Dynamic Programming):
 *    - dp[i] = minimum jumps to reach position i
 *    - dp[-1] = 0 (starting position)
 *    - For each position i with a leaf, calculate dp[i] from all positions j where (i-j) is Fibonacci
 *    - Answer is dp[N]
 *
 * ALGORITHM OUTLINE:
 * 1. Generate Fibonacci numbers up to N+1
 * 2. Use BFS starting from position -1
 * 3. For each position, try jumping by each Fibonacci distance
 * 4. Track visited positions to avoid cycles
 * 5. Return jumps when reaching position N, or -1 if impossible
 */


public class FibFrog {

    public static class PJPair{
        int position;
        int jumps;

        public PJPair(int position, int jumps) {
            this.position = position;
            this.jumps = jumps;
        }
    }
    // TODO: Implement your solution here
    public int solution(int[] A) {
        // Your code goes here
        int curPosition = -1;
        int n = A.length;
        List<Integer> fibList = generateFibonacci(n+1);
        Queue<PJPair> fibQueue = new LinkedList<>();
        // 1st time
        for (Integer fib : fibList) {
            if(A[curPosition + fib] == 1){
                PJPair pjPair = new PJPair(curPosition + fib, 1);
                fibQueue.add(pjPair);
            }
        }
        // any of those reached to the goal?
        while(checkIfAnyReachedEndYet(fibQueue, n)){
                PJPair pjPair = fibQueue.poll();
                if(pjPair == null){
                    return -1;
                }
                curPosition = pjPair.position;

                for (Integer fib : fibList) {
                    if (A[curPosition + fib] == 1) {
                        pjPair.position = curPosition + fib;
                        pjPair.jumps += 1;
                        fibQueue.add(pjPair);
                    }
                }
        }
        

        return fibQueue.peek()  == null? -1: fibQueue.peek().jumps;
    }
    
    private boolean checkIfAnyReachedEndYet(Queue<PJPair> fibQueue, int n) {
        for (PJPair pjPair : fibQueue) {
            if (pjPair.position >= n) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper function: Generate Fibonacci numbers up to limit
     */
    private List<Integer> generateFibonacci(int limit) {
        List<Integer> fibs = new ArrayList<>();
        int a = 1, b = 1;
        while (a <= limit) {
            fibs.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        return fibs;
    }

    // ==================== TEST CASES ====================

    public static void main(String[] args) {
        FibFrog solution = new FibFrog();

        // Test Case 1: Example from problem
        System.out.println("Test 1 - Example from problem:");
        int[] A1 = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        int result1 = solution.solution(A1);
        System.out.println("Input: [0,0,0,1,1,0,1,0,0,0,0]");
        System.out.println("Expected: 3");
        System.out.println("Got: " + result1);
        System.out.println("Path: -1 -> 4 (F5=5) -> 6 (F3=2) -> 11 (F5=5)");
        System.out.println();

        // Test Case 2: Empty array (N=0)
        System.out.println("Test 2 - Empty array:");
        int[] A2 = {};
        int result2 = solution.solution(A2);
        System.out.println("Input: []");
        System.out.println("Expected: 0");
        System.out.println("Got: " + result2);
        System.out.println("Already at position 0");
        System.out.println();

        // Test Case 3: Single leaf at position 0
        System.out.println("Test 3 - Single leaf:");
        int[] A3 = {1};
        int result3 = solution.solution(A3);
        System.out.println("Input: [1]");
        System.out.println("Expected: 1");
        System.out.println("Got: " + result3);
        System.out.println("Jump F(2)=1 from -1 to 0, then F(2)=1 to position 1");
        System.out.println();

        // Test Case 4: Direct jump to goal
        System.out.println("Test 4 - Direct jump (Fibonacci distance):");
        int[] A4 = {0, 0, 0, 0};  // N=4, but 5 is F(5)
        int result4 = solution.solution(A4);
        System.out.println("Input: [0,0,0,0] (N=4)");
        System.out.println("Expected: 1 (can jump F(5)=5 from -1 to 4)");
        System.out.println("Got: " + result4);
        System.out.println();

        // Test Case 5: Impossible case
        System.out.println("Test 5 - Impossible to cross:");
        int[] A5 = {0, 0, 0};
        int result5 = solution.solution(A5);
        System.out.println("Input: [0,0,0]");
        System.out.println("Expected: -1");
        System.out.println("Got: " + result5);
        System.out.println("No Fibonacci jump reaches position 3 from -1 without leaves");
        System.out.println();

        // Test Case 6: All leaves
        System.out.println("Test 6 - All leaves:");
        int[] A6 = {1, 1, 1, 1, 1};
        int result6 = solution.solution(A6);
        System.out.println("Input: [1,1,1,1,1]");
        System.out.println("Expected: 2 or 3 (multiple paths possible)");
        System.out.println("Got: " + result6);
        System.out.println("E.g., -1 -> 0 (F2=1) -> 2 (F3=2) -> 5 (F4=3)");
        System.out.println();

        // Test Case 7: Strategic leaf placement
        System.out.println("Test 7 - Strategic leaves:");
        int[] A7 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};  // Only leaf at 0
        int result7 = solution.solution(A7);
        System.out.println("Input: [1,0,0,0,0,0,0,0,0,0,0,0]");
        System.out.println("Expected: 2");
        System.out.println("Got: " + result7);
        System.out.println("Path: -1 -> 0 (F2=1) -> 12 (F7=13)? or -1 -> 0 -> 13?");
        System.out.println();

        // Test Case 8: Fibonacci positions
        System.out.println("Test 8 - Leaves at Fibonacci positions:");
        int[] A8 = new int[13];
        A8[0] = 1;   // F(2) = 1
        A8[1] = 1;   // F(3) = 2
        A8[2] = 1;   // F(4) = 3
        A8[4] = 1;   // F(5) = 5
        A8[7] = 1;   // F(6) = 8
        A8[12] = 1;  // F(7) = 13
        int result8 = solution.solution(A8);
        System.out.println("Input: Leaves at positions 0,1,2,4,7,12");
        System.out.println("Expected: 1 or 2");
        System.out.println("Got: " + result8);
        System.out.println();

        // Test Case 9: Large gap with strategic leaf
        System.out.println("Test 9 - Large gap:");
        int[] A9 = new int[100];
        A9[4] = 1;  // F(5) = 5, position 4
        A9[9] = 1;  // F(5) = 5 more, position 9
        int result9 = solution.solution(A9);
        System.out.println("Input: Array of 100, leaves at positions 4 and 9");
        System.out.println("Expected: varies");
        System.out.println("Got: " + result9);
        System.out.println();

        // Test Case 10: Minimum N requiring multiple jumps
        System.out.println("Test 10 - Two jumps minimum:");
        int[] A10 = {0, 0, 1};  // N=3, need to land on position 2 first
        int result10 = solution.solution(A10);
        System.out.println("Input: [0,0,1]");
        System.out.println("Expected: 2");
        System.out.println("Got: " + result10);
        System.out.println("Path: -1 -> 2 (F4=3) -> 3 (F2=1)");
        System.out.println();

        // Test Case 11: Can reach directly or via leaves
        System.out.println("Test 11 - Direct vs indirect:");
        int[] A11 = {1, 0, 0, 0, 1};  // N=5, which is F(5)
        int result11 = solution.solution(A11);
        System.out.println("Input: [1,0,0,0,1]");
        System.out.println("Expected: 1");
        System.out.println("Got: " + result11);
        System.out.println("Direct jump F(6)=8? No. F(5)=5 from -1 to position 4? Or to 5?");
        System.out.println();

        // Test Case 12: Large array with scattered leaves
        System.out.println("Test 12 - Large scattered leaves:");
        int[] A12 = new int[50];
        A12[1] = 1;
        A12[4] = 1;
        A12[9] = 1;
        A12[16] = 1;
        A12[25] = 1;
        A12[36] = 1;
        A12[49] = 1;
        int result12 = solution.solution(A12);
        System.out.println("Input: Array of 50, leaves at 1,4,9,16,25,36,49");
        System.out.println("Expected: varies");
        System.out.println("Got: " + result12);
        System.out.println();

        // Test Case 13: Consecutive leaves near end
        System.out.println("Test 13 - Consecutive leaves:");
        int[] A13 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int result13 = solution.solution(A13);
        System.out.println("Input: [0,0,0,0,0,1,1,1,1,1]");
        System.out.println("Expected: 2");
        System.out.println("Got: " + result13);
        System.out.println("Path: -1 -> 5 (F5=5 or F6=8?) -> 10 (F5=5)");
        System.out.println();
    }
}
