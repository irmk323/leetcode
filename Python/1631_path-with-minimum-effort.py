class Solution(object):
    def minimumEffortPath(self, heights):
        m, n = len(heights), len(heights[0])
        effort = [[math.inf] * n for _ in range(m)]
        effort[0][0] = 0
        minHeap = [(0, 0, 0)] # distance, row, col
        DIR = [0, 1, 0, -1, 0]

        while minHeap:
            d, r, c = heappop(minHeap)
            if d > effort[r][c]: continue 
            if r == m - 1 and c == n - 1:
                return d  # Reach to bottom right
            
            for i in range(4):
                nr, nc = r + DIR[i], c + DIR[i+1]
                if 0 <= nr < m and 0 <= nc < n:
                    new_diff_to_take = max(d, abs(heights[nr][nc] - heights[r][c]))
                    if effort[nr][nc] > new_diff_to_take:
                        effort[nr][nc] = new_diff_to_take
                        heappush(minHeap, (effort[nr][nc], nr, nc))