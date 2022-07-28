# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levels = []
        if not root:
            return levels
        
        self.helper(root, 0, levels)
        return levels
        
    def helper(self, node, level, levels):

        if len(levels) == level:
            levels.append([])

        levels[level].append(node.val)

        if node.left:
            self.helper(node.left, level + 1, levels)
        if node.right:
            self.helper(node.right, level + 1, levels)
            
