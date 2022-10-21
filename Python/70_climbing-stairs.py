# Time: O(n)
# Time: O(1)
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        first = 1
        second = 2
        for i in range(3, n+1):
            third = first + second
            first = second 
            second = third 
        return second
        
        # 1:1 =>1
        # 2:1+1,2 => 2
        # 3:2+1 => 3
        # 4:1+3 =>(1,1,1,1) (2,1,1)(1,2,1)(1,1,2)(2,2) => 5
        # 5:(1,1,1,1,1)(1,2,1,1)(2111)(1121)(1112)(221)(121)(112) => 8
