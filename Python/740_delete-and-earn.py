class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        points = defaultdict(int)
        max_num = 0
        for num in nums:
            points[num] += num
            max_num = max(max_num, num)

        max_points = [0] * (max_num + 1)  
        max_points[1] = points[1]

        for i in range(2, len(max_points)):
            max_points[i] = max(max_points[i-1],max_points[i-2]+points[i])

        return max_points[max_num]