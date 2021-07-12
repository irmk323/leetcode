class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null|| board.length == 0) return;
        solve(board);
    }
     public boolean solve(char[][] board) {
         for(int i = 0; i< board.length; i++){
             for(int j = 0; j< board.length; j++){
                 if(board[i][j] == '.'){
                     for(char c = '1'; c <= '9'; c++){
                         if(isValid(board, i, j, c)){
                             board[i][j] = c;
                             
                             if(solve(board)) return true;
                             else board[i][j] = '.';
                         }
                     }
                     return false;
                 }
             }
         }
         return true;
     }
    public boolean isValid(char[][] board, int row, int col, char c){
        int blrow = row / 3 * 3, blcol = col / 3 * 3;
        for(int i = 0; i< 9 ; i++){
            if(board[row][i] == c || board[i][col] == c || board[blrow + i /3][blcol + i%3] == c)
                return false;
        }
        return true;
        
    }
}
