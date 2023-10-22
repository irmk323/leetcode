class Solution {
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();// this is for checking adjecent layer
        boolean foundFistIsland = false; 
        int n = grid.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j ++){
                if(foundFistIsland) break;
                if(grid[i][j] == 1){
                    dfs(i,j,grid, q);
                    foundFistIsland = true;
                    break;
                }
            }
        }
        return bfs(grid , q);
    }

    public boolean invalid(int r, int c, int[][] grid){
        return (r < 0 || c< 0 || r>= grid.length || c >= grid.length );
    }

    public void dfs(int r, int c, int[][] grid, Queue<int[]> q){
        // 
        if( invalid(r, c, grid) || grid[r][c] != 1){
            return;
        }
        grid[r][c] = -1; //mark it as visited
        q.offer(new int[]{r,c}); // add it to examine 4 direcition neighbor reached to the next island.
        for(int[] d: direction){
            dfs(r+ d[0], c+ d[1], grid, q);
        }
    }
    public int bfs(int[][]grid , Queue<int[]>q){
        int level = 0;
        boolean[][] visited = new boolean[grid.length][grid.length];
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                for(int[]d : direction){
                    int nr = cell[0] + d[0];
                    int nc = cell[1] + d[1];
                    if(invalid(nr,nc, grid) || visited[nr][nc]  ){
                        continue;
                    }
                    if(grid[nr][nc] == 1){
                        return level;
                    }else{
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            level +=1;
        }
        return -1;
    }
}