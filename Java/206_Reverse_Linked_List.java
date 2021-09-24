/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


// iterative 
// Time O(n) Space O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!= null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// retcursive
// Time O(n) Space O(N)
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
    public ListNode reverse(ListNode head , ListNode newHead) {
        if(head == null){
        return newHead;
        } 
        
        ListNode next  = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
        return  reverse(head, newHead);
    }
    
}

