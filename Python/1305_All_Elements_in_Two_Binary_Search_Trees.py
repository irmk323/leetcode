
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# edge case 
# node is empty
# root doesn't have children

# list =  [2,1,4,1,0,3]
# sort(list) -> Brute force
# Time: O(n) + O(nlogn) -> O(nlogn)
# Space: O(n + m) -> O(n)

# sort each Tree node first 
# [1,2,4], [0,1,3]
# we'll merge it to the List wit for loop
# [0,1,1,2,3,4]

class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        l1 = []
        l2 = []
        self.bstToSortedList(root1, l1)
        self.bstToSortedList(root2, l2)
        return self.mergeSortedLists(l1, l2)

    def bstToSortedList(self,root:TreeNode ,sorted_list: list[int])-> None:
        if root is None:
            return 
        self.bstToSortedList(root.left , sorted_list)
        sorted_list.append(root.val)
        self.bstToSortedList(root.right, sorted_list)

    def mergeSortedLists(self, l1: List[int], l2: List[int])-> List[int]:
        total_len = len(l1)+len(l2)
        i1, i2 = 0, 0
        result = []
        while len(result) < total_len:
            if i1 >= len(l1):
                result.append(l2[i2])
                i2+=1
            elif i2 >= len(l2):
                result.append(l1[i1])
                i1+=1
            elif l1[i1] <= l2[i2]:
                result.append(l1[i1])
                i1+=1
            elif l1[i1] > l2[i2]:
                result.append(l2[i2])
                i2+=1
        return result
        

    
       
