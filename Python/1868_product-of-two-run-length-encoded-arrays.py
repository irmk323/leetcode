# Time: O(n) n... length of encoded1 
# Space: O(n)
class Solution:
    def findRLEArray(self, encoded1: List[List[int]], encoded2: List[List[int]]) -> List[List[int]]:
        return self.multiply(encoded1, encoded2)
    
    def multiply(self, encoded1: List[List[int]], encoded2: List[List[int]]) -> List[List[int]]:
        result = []
        i = j = 0
        while i < len(encoded1):
            if encoded1[i][1] == encoded2[j][1]:
                self.result_append(result, [ encoded1[i][0] * encoded2[j][0], encoded1[i][1]] )
                i +=1
                j +=1
            else:
                self.result_append(result, [encoded1[i][0] * encoded2[j][0], min(encoded1[i][1],encoded2[j][1]) ])
                if encoded1[i][1] > encoded2[j][1]:
                    encoded1[i][1] -= encoded2[j][1]
                    j +=1 
                else:
                    encoded2[j][1] -= encoded1[i][1]
                    i += 1
        
        return result
    
    def result_append(self, result:List[List[int]], elem:List[int]):
        if not result or result[-1][0] != elem[0]:
            result.append(elem)
        else:
            result[-1][1] += elem[1] 
            
        
    
    # def simplify(self, nums:List[List[int]])-> List[List[int]]:
    #     result = []
    #     cur_len = nums[0][1]
    #     last = nums[0][0]
    #     for i in range(1, len(nums)):
    #         if nums[i][0] != last:
    #             result.append([last, cur_len])
    #             cur_len = nums[i][1]
    #             last = nums[i][0]
    #         else:
    #             cur_len += nums[i][1]
    #     result.append([last, cur_len])
    #     return result