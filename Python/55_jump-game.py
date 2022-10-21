class Solution:
    def canJump(self, nums: List[int]) -> bool:
        last = len(nums) -1
        for i in range(last, -1, -1):
            if i + nums[i] >= last:
                last = i
        return last == 0
        
        