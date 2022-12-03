class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        left = right = 0
        while left < len(s) and right < len(t):
            if s[left] == t[right]:
                left +=1
            right +=1
        return True if left == len(s) else False
