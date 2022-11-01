class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # Time: O( n * m )
        if needle == "":
            return 0
        for i in range(len(haystack) + 1 - len(needle)):
            if haystack[i: i+ len(needle)] == needle:
                return i
        return -1
        
# or KMP solution could be O(n +m)