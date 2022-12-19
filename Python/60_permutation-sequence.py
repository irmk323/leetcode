import math
class Solution:
    def getPermutation(self, n, k):
        numbers = list(range(1, n+1))
        permutation = ''
        k -= 1 
        #  k -=1 is because we separately have first index section as 0 index counter https://www.youtube.com/watch?v=wT7gcXLYoao (6:47)
        while n > 0:
            n -= 1
            # get the index of current digit

            index, k = divmod(k, math.factorial(n))
            permutation += str(numbers[index])
            # remove handled number
            numbers.remove(numbers[index])

        return permutation