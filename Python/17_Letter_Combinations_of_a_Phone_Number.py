class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        # empty string edge case
        if not digits:
            return []

        # just 1 number
        mapping =  { 
            '2': ['a', 'b', 'c'], 
            '3': ['d','e','f'], 
            '4': ['g','h','i'], 
            '5': ['j','k','l'], 
            '6': ['m','n','o'], 
            '7': ['p','q','r', 's'], 
            '8': ['t','u', 'v'], 
            '9': ['w','x','y', 'z']
        }
        # nested for loops
        return self.cartesian(digits, mapping, [''])
    
    def cartesian(self, digits, mapping, aux) -> List[str]:
        if not digits:
            return aux
        
        last_digit = digits[-1]
        
        new_aux = []
        for word in aux:
            for letter in mapping[last_digit]:
                new_aux.append(letter + word)
            
        return self.cartesian(digits[:-1], mapping, new_aux)
