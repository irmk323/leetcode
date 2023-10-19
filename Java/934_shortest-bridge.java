class Solution {
    private int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>(); // record the first land
        int n = grid.length;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, q);
                    found = true;
                    break;
                }
            }
        }

        return bfs(grid, q);
    }

    private boolean invalid(int r, int c, int n) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }

    private void dfs(int r, int c, int[][] grid, Queue<int[]> q) {
        if (invalid(r, c, grid.length) || grid[r][c] != 1) {
            return;
        }
        grid[r][c] = -1; 
        q.offer(new int[]{r, c});
        for (int[] d : direction) {
            int i = r + d[0];
            int j = c + d[1];
            dfs(i, j, grid, q);
        }
    }

    private int bfs(int[][] grid, Queue<int[]> q) {
        int level = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                for (int[] d : direction) {
                    int nr = cell[0] + d[0];
                    int nc = cell[1] + d[1];

                    if (invalid(nr, nc, grid.length) || visited[nr][nc]) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        return level;
                    } else {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            level += 1;
        }
        return -1;
    }
}
