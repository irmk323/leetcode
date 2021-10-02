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

// Time O(n+m) Space O(1)
// Recursive is skipped because of space is O(n+m)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode curr = prev;
        while(l1 != null && l2 != null){
            // <= でも　< でもどっちでもいい
            if(l1.val < l2.val){
                curr.next = l1;
                l1= l1.next;
            }else{
                curr.next = l2;
                l2= l2.next;
            }
            curr = curr.next;
        }
        curr.next= l1 == null ? l2 : l1;
        return prev.next;
    }
}
