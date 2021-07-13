class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solved(board);
    }
    public boolean solved(char[][] board){
        for(int i =0; i< board.length; i++){
            for(int j =0; j< board.length; j++){
               if(board[i][j] == '.'){
                   for(char c= '1'; c<= '9'; c++){
                       //check if the char is used same row, col, and devided small box.
                       if(isValid(board, i, j, c)){
                           board[i][j] = c;
                           // search next '.' after put c once;
                           if(solved(board)) return true;
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
        //  9x9のボックスを①から⑨に分ける(devide 9x9 small boxies )
        int blkrow = row/3 * 3, blkcol = col/3 * 3;
        for(int i = 0; i<9; i++){
            if(board[row][i] == c || board[i][col] == c||
                //  9x9のボックスを①から⑨に分けた場合で⑤（真ん中）の場合、
               // example if you are at 5 of devided box(middle)
               // (i=0)[3,3]->(i=1)[3,4]->(i=2)[3,5]->
               // (i=3)[4,3]->(i=3)[4,4]...
               //
              board[blkrow + i / 3][blkcol + i % 3 ]==c) return false;            
        }
        return true;
    }
}
