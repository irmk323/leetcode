class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        def backtrack(first = 1, cur =[]):
            if len(cur) == k:
                res.append(cur[:])
            for i in range(first, n +1):
                cur.append(i)
                backtrack(i+1, cur)
                cur.pop()
        backtrack()        
        return res
                
        