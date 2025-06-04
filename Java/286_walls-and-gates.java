class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1, 0 },
            new int[] { -1, 0 },
            new int[] { 0, 1 },
            new int[] { 0, -1 });

    public void wallsAndGates(int[][] rooms) {

        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == GATE) {
                    q.add(new int[] { i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int m = point[0];
            int n = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = m + direction[0];
                int c = n + direction[1];

                if (r < 0 || c < 0 || r >= row || c >= col || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[m][n] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
}