# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res = []
        temp = []
        def traverse(node:TreeNode, temp):
            if node is None:
                return
            temp.append(str(node.val))
            # end of leaf
            if node.left is None and node.right is None:
                res.append("->".join(temp))
                
            traverse(node.left, temp)
            traverse(node.right, temp)
            
            temp.pop()
            
        traverse(root, temp)
        return res
