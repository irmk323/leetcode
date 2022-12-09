# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return True
        fast = head
        second = head
        while (fast.next is not None and fast.next.next is not None ):
            fast = fast.next.next
            second = second.next
        
        second_half = self.reverse(second.next)
        first_half = head

        while (second_half is not None and first_half is not None):
            if second_half.val != first_half.val:
                return False
            second_half= second_half.next
            first_half = first_half.next
        return True

    def reverse(self, second_half:ListNode):
        prev = None
        cur = second_half
        while cur is not None:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        return prev
