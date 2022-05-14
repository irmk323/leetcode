"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:

    def maxDepth(self, root) -> int:
        return self.searchNode(root, 0)

    def searchNode(self, root , depth: int):
        if root is None:
            return depth
        depth += 1
        maxdepth = 0
        for child in root.children:
            current_depth = self.searchNode(child, 0)
            if current_depth > maxdepth:
                maxdepth = current_depth
        return maxdepth + depth
                
            
        
        
