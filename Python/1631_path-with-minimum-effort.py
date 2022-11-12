class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        col = len(heights[0])
        row = len(heights)
        effort = [[math.inf] * col for _ in range(row) ]
        effort[0][0] = 0
        minHeap = [(0,0,0)]
        DIR = [0,-1, 0, 1, 0]
        
        while minHeap:
            d,r,c = heappop(minHeap)
            if c == col -1 and r == row -1:
                return d
            for i in range(4):
                nr, nc = r + DIR[i], c + DIR[i+1]
                if 0 <= nr < row and 0 <= nc < col:
                    new_diff_to_take = max(d, abs(heights[nr][nc] - heights[r][c]))
                    if effort[nr][nc] > new_diff_to_take:
                        effort[nr][nc] = new_diff_to_take
                        heappush(minHeap, (effort[nr][nc], nr, nc))
        