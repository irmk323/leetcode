class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];
        if (original != color){
            dfs(image, sr,sc,original, color);
        }
        return image;
    }

    public void dfs(int[][] image, int r, int c,int original,  int color){
        int xLen = image.length;
        int yLen = image[0].length;
        if (0 <=  r  && r < xLen && 0 <= c  && c < yLen && image[r][c] == original){
            image[r][c] = color;
            dfs(image, r+1, c, original, color);
            dfs(image, r, c+1, original, color);
            dfs(image, r-1, c, original, color);
            dfs(image, r, c-1, original, color);
        }
    }
}