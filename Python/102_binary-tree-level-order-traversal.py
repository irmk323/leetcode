# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from ensurepip import version


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
            
# ==============================
# queue version


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
        
        level = 0
        queue = deque([root,])
        while queue:
            levels.append([])
            levels_len = len(queue)
            for i in range(levels_len):
                node = queue.popleft()
                levels[level].append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)         
            level +=1
        
        return levels
        