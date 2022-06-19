class Solution:
    def digitCount(self, num: str) -> bool:
        counts = [0] * 10
        # 0309
        for digit in num:
            counts[int(digit)] += 1
        for i in range(len(num)):
            if counts[i] != int(num[i]):
                return False
        return True
    
    # Time  O(1) 
    # Space 10 -> O(1)
                
            
        
