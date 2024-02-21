
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rowL = mat.length;
        int colL = mat[0].length;
        int[][] ans = new int[rowL][colL];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i< rowL; i++){
            for(int j = 0;  j< colL; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int[] dir: dirs){
                int newR = row + dir[0];
                int newC = col + dir[1];

                if(isRange(mat, newR, newC) && ans[newR][newC] > ans[row][col] +1){
                    ans[newR][newC] = ans[row][col] +1;
                    queue.offer(new int[]{newR,newC});
                }
            }
        }
        return ans;
    }
    private boolean isRange(int[][] mat, int row, int col){
        return 0<= row && row < mat.length && 0<= col && col < mat[0].length;
    }
}


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length, INF = m+n;
        for(int r = 0;  r< m; r++){
            for(int c = 0; c < n; c++){
                if(mat[r][c] == 0) continue;
                int top = INF, left = INF;
                if(r > 1) top = mat[r-1][c];
                if(c > 1) left = mat[r][c-1];
                mat[r][c] = Math.min(top, left) +1;
            }
        }
        for(int r = m -1 ;  r >= 0; r--){
            for(int c = n -1; c >= 0; c --){
                if(mat[r][c] == 0) continue;
            int bottom = INF, right = INF;
            if(r < m-1) bottom = mat[r + 1][c];
            if(c < n-1) right = mat[r][c+1];
            mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) +1);
            }
        }
        return mat;
    }
}