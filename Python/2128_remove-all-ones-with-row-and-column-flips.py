# Time: O(m * n)
# Space:O(n)
class Solution:
    def removeOnes(self, grid: List[List[int]]) -> bool:
        # edge cases
        # 1 x 1 -> true
        # 1 row or one col if it has same values, true
        if len(grid) == 1 or len(grid[0]) == 1:
            return True
        # if len(grid) == 1: #[[1, 0, 1]]
        #     return sum(grid[0]) in [0,len(grid[0])]
        
#         if len(grid[0]) == 1: # [[1],[0],[1]] -> [1,0,1]
#             return sum([ row[0] for row in grid ]) in [0,len(grid)]
        
        # check by row if it's same as 1st or flip values as 1st row
        for i in range(1, len(grid)):
        # same [0,1,0],[1,0,1] -> zip -> [(0, 1), (1, 0), (0, 1)] 
        # -> [False, False, False]

            are_same = [tuple[0] == tuple[1] for tuple in zip(grid[0],grid[i])]
            flipped = [ not is_same for is_same in are_same] 
            if not all(are_same) and not all(flipped):
                return False
        return True
        