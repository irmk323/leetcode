class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet[] row = new HashSet[9];
        HashSet[] col = new HashSet[9];
        HashSet[] box = new HashSet[9];

        for(int i =0; i< 9;i++){
            row[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
            box[i] = new HashSet<Character>();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j< 9; j++){
                if(board[i][j] != '.'){
                    if(row[i].contains(board[i][j]) ||
                    col[j].contains(board[i][j]) || 
                    box[3*(i/3) + j/3].contains(board[i][j])){
                        return false;
                    }else{
                        row[i].add(board[i][j]);
                        col[j].add(board[i][j]);
                        box[3*(i/3) + j/3].add(board[i][j]);
                    }
                }

            }
        }
        return true;
    }
}