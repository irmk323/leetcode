import java.util.Arrays;
import java.util.Random;

public class Solution {

    /* =====================
     * Codility 提出用メソッド
     * ===================== */
    public int solution(int[] A) {
        int n = A.length;

        int bestIdx = 0;
        long bestNum = (long) A[0] + A[1]; // numerator
        long bestDen = 2;                  // denominator

        for (int i = 0; i < n - 1; i++) {

            // length = 2
            long num2 = (long) A[i] + A[i + 1];
            if (isBetter(num2, 2, bestNum, bestDen, i, bestIdx)) {
                bestNum = num2;
                bestDen = 2;
                bestIdx = i;
            }

            // length = 3
            if (i + 2 < n) {
                long num3 = num2 + A[i + 2];
                if (isBetter(num3, 3, bestNum, bestDen, i, bestIdx)) {
                    bestNum = num3;
                    bestDen = 3;
                    bestIdx = i;
                }
            }
        }
        return bestIdx;
    }

    private boolean isBetter(long numA, long denA,
                             long numB, long denB,
                             int idxA, int idxB) {
        // numA / denA < numB / denB ?
        long left = numA * denB;
        long right = numB * denA;

        if (left < right) return true;
        if (left > right) return false;

        // 平均が同じなら index が小さい方
        return idxA < idxB;
    }

    /* =====================
     * テスト実行用 main
     * ===================== */
    public static void main(String[] args) {
        Solution sol = new Solution();

        runFixedTests(sol);
        runRandomBruteTests(sol, 5, 42L);

        System.out.println("\nALL TESTS PASSED ✅");
    }

    /* =====================
     * 固定テスト（15）
     * ===================== */
    private static void runFixedTests(Solution sol) {
        System.out.println("Running fixed tests...");

        check(sol, "T01 example",
                new int[]{4, 2, 2, 5, 1, 5, 8}, 1);

        check(sol, "T02 minimal",
                new int[]{5, -5}, 0);

        check(sol, "T03 all equal",
                new int[]{7, 7, 7, 7}, 0);

        check(sol, "T04 increasing",
                new int[]{1, 2, 3, 4, 5}, 0);

        check(sol, "T05 decreasing",
                new int[]{5, 4, 3, 2, 1}, 3);

        check(sol, "T06 negatives",
                new int[]{-3, -5, -8, -4, -10}, 2);

        check(sol, "T07 tie choose smallest index",
                new int[]{0, 0, 0, 0}, 0);

        check(sol, "T08 min at end",
                new int[]{5, 5, 5, -10, -10}, 3);

        check(sol, "T09 3-length wins",
                new int[]{10, 10, -100, 10, 10}, 1);

        // ★ 修正済み：Expected = 1
        check(sol, "T10 alternating",
                new int[]{5, -5, 5, -5, 5, -5}, 1);

        check(sol, "T11 large values",
                new int[]{10000, 10000, -10000, -10000}, 2);

        check(sol, "T12 middle pair",
                new int[]{3, 1, 2, -5, -6, 4}, 3);

        check(sol, "T13 many ties",
                new int[]{1, 1, 1, 0, 0, 0}, 3);

        check(sol, "T14 tricky 3-slice",
                new int[]{8, -4, -4, -4, 10}, 1);

        // 大規模テスト
        int n = 100_000;
        int[] big = new int[n];
        Arrays.fill(big, 10_000);
        big[54321] = -10_000;
        big[54322] = -10_000;

        check(sol, "T15 big array",
                big, 54321);
    }

    /* =====================
     * ランダム + brute force（5）
     * ===================== */
    private static void runRandomBruteTests(Solution sol, int count, long seed) {
        System.out.println("\nRunning random brute-force tests...");
        Random rnd = new Random(seed);

        for (int t = 1; t <= count; t++) {
            int n = 2 + rnd.nextInt(20);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = rnd.nextInt(20001) - 10000;
            }

            int expected = bruteMinAvgIndex(a);
            int got = sol.solution(a);

            if (expected != got) {
                System.out.println("FAILED random test");
                System.out.println(Arrays.toString(a));
                System.out.println("Expected=" + expected + ", Got=" + got);
                throw new AssertionError();
            }
            System.out.println("  random OK: " + Arrays.toString(a));
        }
    }

    /* =====================
     * O(N^2) brute（検証用）
     * ===================== */
    private static int bruteMinAvgIndex(int[] A) {
        int n = A.length;
        int bestIdx = 0;
        long bestNum = (long) A[0] + A[1];
        long bestDen = 2;

        for (int p = 0; p < n - 1; p++) {
            long sum = A[p];
            for (int q = p + 1; q < n; q++) {
                sum += A[q];
                long den = q - p + 1;

                long left = sum * bestDen;
                long right = bestNum * den;

                if (left < right || (left == right && p < bestIdx)) {
                    bestIdx = p;
                    bestNum = sum;
                    bestDen = den;
                }
            }
        }
        return bestIdx;
    }

    private static void check(Solution sol, String name, int[] a, int expected) {
        int got = sol.solution(a);
        if (got != expected) {
            System.out.println("FAILED " + name);
            System.out.println(Arrays.toString(a));
            System.out.println("Expected=" + expected + ", Got=" + got);
            throw new AssertionError();
        }
        System.out.println("  " + name + " OK");
    }
}
