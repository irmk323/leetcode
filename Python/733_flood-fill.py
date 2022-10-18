class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        xlen = len(image)
        ylen = len(image[0])
        ori = image[sr][sc]
        
        def dfs(x,y):
            if 0<= x < xlen and 0<= y < ylen and image[x][y] ==ori:
                image[x][y] = color
                dfs(x -1,y)
                dfs(x +1,y)
                dfs(x ,y-1)
                dfs(x ,y+1)
                
        if ori != color:
            dfs(sr,sc)
        return image
        