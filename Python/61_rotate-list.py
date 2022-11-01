# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return None
        last = head
        length = 1
        
        while (last.next):
            last = last.next
            length += 1
        
        k = k % length # e.g. if it rotate the same time as the length of list
        last.next = head # make it as circler list for now
        
        # last node is ( n - k -1)
        temp = head
        for _ in range(length - k -1):
            temp = temp.next
        
        answer = temp.next
        temp.next = None # cut off the last node
        
        
        return answer