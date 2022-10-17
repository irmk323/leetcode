class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # ===This is time exceed
        # matrix = {}
        # for i, value in enumerate(nums):
        #     matrix[i] = value
        # result = [1] * len(nums)
        # for i in matrix:
        #     for j in range(len(matrix)):
        #         if i != j:
        #             result[i] *= matrix[j]
        # return result
        
        # this is 
        # Time O(n), Space O(1)
        length = len(nums)
        answer = [1] * length
        
        answer[0] =1
        for i in range(1, length):
            answer[i] = nums[i-1] * answer[i-1]
            
        R = 1
        for i in reversed(range(length)):
            answer[i] = answer[i] * R
            R *= nums[i]
        return answer
                    