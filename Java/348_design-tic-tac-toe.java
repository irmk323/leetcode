class TicTacToe {
    public int[][] countByPlayerRow; 
    public int[][] countByPlayerCol;
    public int[] countByPlayerDiagTopLeft;
    public int[] countByPlayerDiagRightBottom;
    public int n;
    public TicTacToe(int n) {
        // int[][] ticTacToe = new int [n][n];
        countByPlayerRow = new int[2][n];
        countByPlayerCol = new int[2][n];
        countByPlayerDiagTopLeft = new int[2];
        countByPlayerDiagRightBottom = new int[2];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        countByPlayerRow[player-1][row] +=1;
        countByPlayerCol[player-1][col] +=1;
        if (row == col ){
            countByPlayerDiagTopLeft[player-1] += 1;
        }
        if ( (col +row) == (n-1)){
            countByPlayerDiagRightBottom[player-1] += 1;
        }
        if (countByPlayerRow[player-1][row] == n ||
            countByPlayerCol[player-1][col] == n || 
            countByPlayerDiagTopLeft[player-1] == n ||
            countByPlayerDiagRightBottom[player-1] == n
            ){
                return player;
            }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */