class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0] * n # result: [0,0,0,0,0]
        left = 0
        right = n -1
        # range(start, stop, step)
        # start ≦ i < stop
        for i in range(right, -1, -1):
            if abs(nums[left]) < abs(nums[right]):
                square = nums[right]
                right -= 1
            else:
                square = nums[left]
                left += 1
            result[i] = square * square
        return result
