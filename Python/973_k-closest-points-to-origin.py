import math
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        h = []
        for x, y in points:
            distance = (x * x ) + (y * y)
            heappush(h, [math.sqrt(distance), x,y])
        ans = []
        for i in range(k):
            coordinate = heappop(h)
            del coordinate[0]
            ans.append(coordinate)
        return ans