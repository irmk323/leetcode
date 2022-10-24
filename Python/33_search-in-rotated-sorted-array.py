class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right= 0, len(nums) -1
        while left <= right:
            mid = (left + right) //2
            if nums[mid] == target:
                return mid
            elif nums[mid] >= nums[left]:
                if target < nums[mid] and target >= nums[left]:
                    right = mid -1
                else:
                    left = mid + 1            
            else:
                if  nums[mid] < target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid -1
        return -1
                
            
        