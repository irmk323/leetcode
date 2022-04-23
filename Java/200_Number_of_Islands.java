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
