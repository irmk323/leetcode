class Solution {
    int size = 0;
    public int totalNQueens(int n) {
        size = n;
        return backTrack(0, new HashSet<>(),new HashSet<>(),new HashSet<>());
    }
    private int backTrack(int row, Set<Integer> diagno, Set<Integer> antiDiago,  Set<Integer> cols){
        if (row == size) return 1;
        
        int solutions = 0;
        for(int col = 0; col < size; col++){
            int currDiagno = row - col;
            int currAntiDiagno = row + col;
            if(cols.contains(col) ||
               diagno.contains(currDiagno) ||
               antiDiago.contains(currAntiDiagno)
              ){
                continue;
            }
               cols.add(col);
               diagno.add(currDiagno);
               antiDiago.add(currAntiDiagno);
            
            solutions += backTrack(row +1 ,diagno, antiDiago, cols );
            
               cols.remove(col);
               diagno.remove(currDiagno);
               antiDiago.remove(currAntiDiagno);
        }
        return solutions;
    }
}
