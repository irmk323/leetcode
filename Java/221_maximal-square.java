class Solution {
    public int maximalSquare(char[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        int[][] dp = new int[row+1][col+1];
        int maxSquare = 0;
        for(int i = 1; i<= row; i++){
            for(int j = 1; j<= col; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        return maxSquare * maxSquare;
    }
}