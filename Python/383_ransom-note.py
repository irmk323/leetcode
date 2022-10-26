class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        magazine_map = {}
        for elm in magazine:
            if elm not in magazine_map:
                magazine_map[elm] = 1
            else:
                magazine_map[elm] +=1
        
        for elm in ransomNote:
            if elm not in magazine_map or magazine_map[elm] <= 0:
                return False
            else:
                magazine_map[elm] -= 1
        return True
        