# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time: O(nlogn)
# Space: O(n)
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return root
        # 1st iteration .. how many colums it has.
        min_col, max_col = dfs(0, 0, 0 ,root) # [-2, 2]
        result = [[] for _ in range((max_col - min_col + 1)) ]
        # 2nd iteration .. root, left, right DFS
        # DFS doesn't work.. B
        populate_result(0 - (min_col), result, root)
        return result
    
def dfs(min_seen :int, max_seen :int, cur:int,root: Optional[TreeNode]) -> tuple[int, int]:
    
    if root is None:
        return (min_seen +1 , max_seen-1)
    left_min, left_max = dfs(min(min_seen,cur-1), max_seen, cur-1, root.left)
    right_min, right_max = dfs(min_seen, max(max_seen,cur+1), cur+1, root.right)
     
    return (min(left_min, right_min), max(left_max,right_max))

def populate_result(cur:int, result:List[List[int]], root)-> None:
    # deque .. can input, and output the data.
    queue = deque()
    # append to the last
    queue.append((root, cur))

    while queue:
        for _ in range(len(queue)):
            # pick up the data from top
            node, col = queue.popleft()
            result[col].append(node.val)
            if node.left:
                queue.append((node.left, col-1))
            if node.right:
                queue.append((node.right, col+1))
