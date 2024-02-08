class Solution {
    private int N;
    private int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    private boolean insideMatrix(int i , int j){
        return 0<= i && i < N && 0 <=j && j <N;
    }

    private void addProbability(double[][] result, int i, int j, double initialProb){
        double curProb =  initialProb / directions.length;
        for(int[] direction: directions){
            int iNew = i + direction[0];
            int jNew = j + direction[1];
            if(insideMatrix(iNew,jNew )){
                result[iNew][jNew] += curProb;
            }
        }

    }
    private double[][] checkCells(double[][] matrix){
        double[][] result = new double[N][N];
        for(int i = 0; i< N; i++){
            for(int j =0; j< N; j++){
                double currentProbability = matrix[i][j];
                if(matrix[i][j] > 0){
                    addProbability(result, i, j , currentProbability);
                }
            }
        }
        return result;
    }

    private double sumCell(double[][] matrix){
        return Arrays
                .stream(matrix)
                .flatMapToDouble(x -> Arrays.stream(x) )
                .sum();
    }

    public double knightProbability(int n, int k, int row, int column) {
        N = n;
        double[][] matrix = new double[N][N];
        matrix[row][column] = 1.0;
        for(int i = 0; i< k; i++){
            matrix = checkCells(matrix);
        }
        return sumCell(matrix);
        
    }
}