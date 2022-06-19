https://leetcode.com/problems/valid-parentheses/
class Solution:
    def isValid(self, s: str) -> bool:
        pair = { "(" : ")", "{" : "}",  "[" : "]"}
        history = []
        for i in s:
            if i == ")" or i == "]" or i == "}":
                if not history or i != pair.get(history.pop()) :
                    return False
            else:
                history.append(i)
        return len(history) == 0 
    
    # time O(N)
    # space O(len(s)) -> O(N)
      # worse -> ((((((
