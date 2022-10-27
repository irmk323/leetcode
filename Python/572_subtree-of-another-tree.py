# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        string_s = self.traverse_tree(root)
        string_t = self.traverse_tree(subRoot)
        if string_t in string_s:
            return True
        return False
    
    def traverse_tree(self, s):
        if s:
            result = f"#{s.val} {self.traverse_tree(s.left)} {self.traverse_tree(s.right)}"
            return result
        return None