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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        
        while(current.next != null && current.next.next != null){
            ListNode first_node = current.next;
            ListNode second_node = current.next.next;
            first_node.next = second_node.next;
            current.next = second_node;
            current.next.next = first_node;
            current = current.next.next;
        }
        return temp.next;
    }
}
