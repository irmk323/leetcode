class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x
        
        first = 2
        last = x // 2 
        while first <= last:
            pivot = (first + last) // 2
            sqrt = pivot * pivot
            if sqrt < x:
                first = pivot +1
            elif sqrt > x:
                last = pivot-1
            else:
                return pivot
        return last