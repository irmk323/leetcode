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
class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode second = reverse(mid.next);
        mid.next= null;
        ListNode first = head;
        while(second != null){
            //evacuate next for each 
            ListNode firstTmp = first.next;
            ListNode secondTmp = second.next;

            first.next = second;
            second.next= firstTmp;
            
            first = firstTmp;
            second = secondTmp;
        }
    }
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode cur = node;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

}