// Time O(M^2 N^2)
// Space O(MN)
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        resRow = mat1.size();
        resCol = mat2[0].size();
        int[][] result = new int[resRow][resCol];
        int[][] denseRows = buildDenseRowMatrix(mat1);
        int[][] denseCols = buildDenseColumnMatrix(mat2);
        // O(MN)
        for(int row = 0; row<resRow; row++){
            for(int col = 0; col<resCol; col++){
                if(???){
                    result[row][col] = calcCell(denseRows[row],denseCols[col])
                }
            }
        }
        return result;
    } 
    public int calcCell(int[] denseRow, int[] denseCol){
        int cellSum = 0;
        for(){ // traversing cells in row of mat1 ( non 0)
            for( denseCol){ 
                // traversing cells in col of mat2
                cellSum +=  cel * mat2[i][0];
            }
        }
        return cellSum;
    }
    public int[][] buildDenseRowMatrix(int[][] mat1){
        List<List<Integer>> rowMatrix = new ArrayList<ArrayList<Integer>>();
        for(int[] row : mat1 ){
            rowMatrix.add(new ArrayList<ArrayList<Integer>>);
            // (0,0,1) => row, col, val
            int column = 0;
            // O(MN)
            for(int cel : row ){
                if(cel != 0){
                    rowMatrix[row].add(new ArrayList<Integer> = [column,cel]);
                }
                column ++;
            }
        }
        return rowMatrix;
    }
    public int[][][] buildDenseColumnMatrix(int[][] mat2){
        List<List<Integer>> colMatrix = new ArrayList<ArrayList<Integer>>();
        for(int col = 0; col< mat2[0].size(); col++ ){
            colMatrix.add(new ArrayList<ArrayList<Integer>>);
            for( int row = 0; row < mat2.size(); row++){
                if( mat2[row][col] != 0){
                    colMatrix[col].add(new ArrayList<Integer> = new int[row,mat2[row][col]]);
                }
            }
        }
    }
}


// 1 2.   5 6.  
// 3 4    7 8
         
// [1,2]  [5,7] prepare cols
// 1* 5 + 2 * 7 = 19 

// 19 