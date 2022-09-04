class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        left_p = 0
        right_p = 0
        result = []
        N = len(nums)
        while left_p < N and right_p < N:
            if right_p + 1 < N and nums[right_p]+1 == nums[right_p + 1]:
                right_p += 1
            else:
                if left_p == right_p:
                    result.append(str(nums[left_p]))
                    left_p = left_p + 1
                    right_p = right_p + 1
                else:
                    result.append(str(nums[left_p]) + '->' +str(nums[right_p]))
                    left_p = right_p + 1
                    right_p = right_p + 1

        return result