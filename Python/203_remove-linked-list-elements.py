# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy_node = ListNode(0)
        dummy_node.next = head

        prev, cur = dummy_node, head
        while cur is not None:
            if cur.val == val:
                prev.next= cur.next
            else:
                prev= cur
            cur = cur.next
        return dummy_node.next
