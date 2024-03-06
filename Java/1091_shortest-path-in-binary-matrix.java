public class Solution {
    private static final int[][] DIRECTIONS = {{-1, -1}, {1, -1}, {-1, 1}, {1, 1}, {0, -1}, {0, 1}, {1, 0}, {-1, 0}};   
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (!isValidCell(0, 0, grid) || !isValidCell(n - 1, n - 1, grid)) return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0], col = cell[1], distance = cell[2];

            if (row == n - 1 && col == n - 1) return distance;

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0], newCol = col + dir[1];

                if (isValidCell(newRow, newCol, grid) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, distance + 1});
                }
            }
        }

        return -1;
    }

    private boolean isValidCell(int row, int col, int[][] grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid.length && grid[row][col] == 0;
    }
}