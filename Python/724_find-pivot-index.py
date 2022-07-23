# Time: O(n)
# Space: O(1)
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        leftnum = 0
        total = sum(nums)
        for i, x in enumerate(nums):
            if leftnum == (total - leftnum  - x):
                return i
            leftnum +=x
        return -1