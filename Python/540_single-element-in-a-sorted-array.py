

class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        left, right = 0, len(nums)-1
        while left < right:
            mid = ( left + right ) // 2
            # if mid is even, then it's duplicate should be in next index.
	        # or if mid is odd, then it's duplicate  should be in previous index.
            # if any of the conditions is satisfied,
            # then pattern is not missed, 
            if (mid % 2 == 1 and nums[mid - 1] == nums[mid]) or (mid%2 == 0 and nums[mid] == nums[mid + 1]):
                left = mid + 1
            else:
                right = mid
        return nums[left]

# first element takes even position and second element takes odd position
# for example, 1 is appeared as a pair,
# so it takes 0 and 1 positions. similarly for all the pairs also.

