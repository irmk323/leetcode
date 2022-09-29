import collections
class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        # intuition
        # use indexes of each row and columns 
          # 0 1 2
        # 0 0 1 2
        # 1 1 2 3
        # 2 2 3 4
        # if it's in the diagnal the sum of column and row are always the same.
        dignals = collections.defaultdict(list)
        for i, num in enumerate(nums):
            for j, elem in enumerate(num):
                    dignals[i+j].append(elem)
        sorted_dignals = sorted(dignals.items())
        result = []
        for dignal in sorted_dignals:
            for i in range(len(dignal[1])-1, -1, -1):
                result.append(dignal[1][i])
        return result
                