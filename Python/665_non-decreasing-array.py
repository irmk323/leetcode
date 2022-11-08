class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        changed = False
        for i in range(len(nums) -1):
            if nums[i] <= nums[i+1]:
                continue
            if changed:
                return False
            # [4,2,10] -> [4,10,10] 
            if i == 0 or nums[i+1] >= nums[i-1]:
                nums[i] = nums[i+1]
            # [3,4,2] -> [3,4,4]
            else:
                nums[i+1] = nums[i]
            changed =True
        return True