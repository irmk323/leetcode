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

//  1 2 3 4 5 6 7 8 
//  1 8 2 7 3 6 4 

// middle 
// reverse 
// merge
class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = findMidNode(head);
        ListNode reverseMid = reverseMid(mid);

        ListNode tmp = null;
        while(reverseMid.next != null){
            tmp = head.next;
            head.next = reverseMid;
            head = tmp;

            tmp = reverseMid.next;
            reverseMid.next = head;
            reverseMid = tmp;
        } 
        
    }

    private ListNode reverseMid(ListNode cur){
        ListNode prev = null;
        ListNode tmp ;
        while(cur != null){
            tmp = cur.next;
            cur.next= prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
    private ListNode findMidNode(ListNode cur){
        ListNode fast = cur;
        ListNode slow = cur;
        while(fast != null && fast.next != null  ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}