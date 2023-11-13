class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
       
        for(int i = 0; i < row; i++){
            for(int j = 0; j< col; j++){
                if( grid[i][j] == 0 && !visited[i][j]){
                    count += dfs(i, j, visited, grid);
                }
            }
        }
        return count;
        
    }
    private int dfs(int r, int c, boolean[][] visited, int[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return 0;
        }
        if( grid[r][c] == 1 || visited[r][c] ){
            return 1;
        }
        visited[r][c] = true;
        // int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
        return ( 
        dfs(r +1, c, visited, grid)
        * dfs(r -1, c, visited, grid)
        *  dfs(r , c+1, visited, grid)
        * dfs(r , c-1, visited, grid));
        }
}