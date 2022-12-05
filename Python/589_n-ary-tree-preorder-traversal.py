"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        def dfs(node: Node,output):
            if node.val is None:
                return
            output.append(node.val)
            for child in node.children:
                dfs(child, output)
        
        output = []
        dfs(root, output)
        return output