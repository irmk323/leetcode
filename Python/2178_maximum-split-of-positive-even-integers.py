class Solution:
    def maximumEvenSplit(self, finalSum: int) -> List[int]:
        if finalSum % 2 == 1:
            return []
        sum = 0
        result_list = []
        even_num = 2 
        while sum < finalSum:
            result_list.append(even_num)
            sum += even_num
            even_num +=2
        extra = sum - finalSum
        
        for num in result_list:
            if num == extra:
                result_list.remove(num)
        return result_list
        
     # 38
     # 2,4,6,8,10,12 ( 42 - 38 = 4) substruct 4 from the list 
     # 2,6,8,10,12

     # 40
     # 2,4,6,8,10,12 ( 42 - 40 = 2) substruct 2 from the list 
     # 4,6,8,10,12

     # 34
     # 2,4,6,8,10,12 ( 42 - 34 = 8) substruct 8 from the list 
     # 2,4,6,10,12( 42 - 34 > 0 )
     
