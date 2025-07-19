// DFS
class Solution {
    public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
      int num_islands = 0;
        for(int y = 0 ; y < grid.length; y++){
            for(int x = 0 ; x < grid[0].length; x++){
                if(grid[y][x] == '1'){
                   num_islands++;
                    visited_island(grid, y, x ); 
                }
            }
        }
        return num_islands;
    }
    
    public void visited_island(char[][] grid, int y, int x){
        if(x < 0 || y < 0 || x >=grid[0].length || y >=grid.length ||
           grid[y][x] == 'X' || grid[y][x] == '0' ){
            return;
        }
        grid[y][x] = 'X';
        visited_island(grid, y - 1, x);
        visited_island(grid, y + 1, x);
        visited_island(grid, y, x - 1);
        visited_island(grid, y, x + 1);
    }
}

//and BFS
class Solution {
    // bfs
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int i, int j){
        Queue<int[]> queue  = new LinkedList<>();
        queue.offer(new int[]{i, j} );
        grid[i][j] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int[] direction: directions){
                int newRow= row + direction[0];
                int newCol =col + direction[1];
                if(newRow <0 || newCol < 0|| grid.length <=newRow || grid[0].length <= newCol
                        || grid[newRow][newCol] == '0'){
                    continue;
                }
                grid[newRow][newCol] = '0';
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}