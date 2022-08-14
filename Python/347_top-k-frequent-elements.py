# Time: O(K log n) worse case is k=n, but average O(K log n)
# Space: 2n + 2n => O(n)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # {1:3, 2:2, 3:1}
        # calclate
        frequency= {}
        # O(n)
        for num in nums:
            if num not in frequency:
                frequency[num] = 0
            frequency[num] +=1
        # Top K is always heap
        # create empty array
        # traverse all over the hashmap
        # convert hashmap into heap
        
        tuples = []
        # O(n)
        for num,freq in frequency.items():
            tuples.append((-freq, num))
        # O(n)
        heapq.heapify(tuples)
        
        result = []
        # O(K log n)
        for i in range(k):
            result.append(heapq.heappop(tuples)[1])      
        return result