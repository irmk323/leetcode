# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Pre fix sum and preorder
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        def preorder(node: TreeNode, cur_sum):
            nonlocal count
            if node is None:
                return
            cur_sum += node.val
            if cur_sum == k:
                count+=1
                
            count += h[cur_sum - k]
            h[cur_sum] +=1
            
            preorder(node.left, cur_sum)
            preorder(node.right, cur_sum)
            
            h[cur_sum] -= 1
        
        count, k = 0, targetSum
        h = defaultdict(int)
        preorder(root, 0)
        return count
        



# My first trial but this solution didn't work
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        total_so_far = 0
        total_paths = 0
        
        def dfs(root, total_so_far):
            nonlocal total_paths
            if root is None:
                return 
            else:
                total_so_far += root.val
                
            if total_so_far == targetSum:
                total_paths += 1
                total_so_far = 0
                return 
                
            if total_so_far > targetSum:
                total_so_far -= root.val
            dfs(root.left,total_so_far)
            dfs(root.right,total_so_far)
            
        dfs(root, total_so_far)
        return total_paths
        
            