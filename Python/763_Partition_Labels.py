class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastIndex = {}
        
        for i, c in enumerate(s):
            lastIndex[c] = i
        res= []
        size, end = 0, 0
        for i, c in enumerate(s):
            size += 1
            end = max(lastIndex[c], end)
            
            if i == end:
                res.append(size)
                size = 0
        return res

# did it again 10/Dec/2022
