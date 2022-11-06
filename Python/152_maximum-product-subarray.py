class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        max_so_far = nums[0]
        min_so_far = nums[0]
        result = max_so_far
        
        for i in range(1, len(nums)):
            cur = nums[i]
            temp_max = max(cur, cur * max_so_far,  cur * min_so_far)
            min_so_far = min(cur, cur * max_so_far,  cur * min_so_far)
            # this is not update the max_so_far value for min_so_far
            max_so_far = temp_max
            result = max(result, max_so_far)
        return result
            
        