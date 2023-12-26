package nonLeetcode.assignment_examples;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 0, 1}));  // 0 を返すべき
    }
    private static int solution(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 0;
        while (i >= 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }
            } else {
                k = 0;
            } 
            i = i - 1;
        }
        // ループ後に最初の要素についても別途処理する
        if (A[0] == 1 && k + 1 > maximal)
            result = 0;

        // 最終的な結果を返す
        return result;
    }


}
   

