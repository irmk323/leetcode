"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        output = []
        self.dfs(output, root)
        return output
    def dfs(self, output:list, root):
        if root is None:
            return
        output.append(root.val)
        
        for child in root.children:
            self.dfs(output, child)
        