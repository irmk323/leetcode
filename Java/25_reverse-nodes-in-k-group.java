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
    public ListNode reverseKGroup(ListNode head, int k) {

     ListNode dummy = new ListNode(0);
     dummy.next = head;
     ListNode groupPrev = dummy;
     ListNode groupNext = head;
     ListNode groupStart = head;
     ListNode groupEnd = head;
     
     while(groupEnd !=null){
        for(int i =0; i<k-1 ;i++){
            if(groupEnd.next != null ){
                groupEnd = groupEnd.next;
            }else{
                return dummy.next;
            }
        }
        groupNext = groupEnd.next;
        reverse(groupStart, groupNext);
        groupPrev.next =groupEnd;
        groupPrev = groupStart;
        groupStart.next = groupNext;
        groupStart = groupNext;
        groupEnd = groupNext;
     }
     return dummy.next;
    }
    private void reverse(ListNode groupStart, ListNode groupNext){
        ListNode prev = null;
        ListNode cur = groupStart;
        while(cur !=groupNext){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
    }
}

// prev → [ start ........ end ] → next