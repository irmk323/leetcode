class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:

        # sort the arrays
        # [[1,3],[3,6],[4,9],[8,10],[15,18][16,27]]
       # [[1,3],[2,6],[8,10],[15,18]]
    
        sorted_intervals = sorted(intervals, key=lambda lst: lst[0])
        result:List[List[int]] = []
            
        for i in range(len(sorted_intervals)):
            if len(result) == 0:
                result.append(sorted_intervals[i]) # [1,3]
            elif self.is_overlap(result[-1], sorted_intervals[i]): 
                 result[-1] = self.merge_sorted_overlapping_intervals(result[-1], sorted_intervals[i])
            else:
                result.append(sorted_intervals[i])
        return result
    
    def is_overlap(self, first:List[int], second:List[int] )->bool:
        return first[1] >= second[0]
    
    def merge_sorted_overlapping_intervals(self, first:List[int], second:List[int] )->List[int]:
        return [first[0], max(first[1], second[1])]
