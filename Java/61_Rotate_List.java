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

// Time O(N) Space O(1) 
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
     if (head==null||head.next==null) return head;
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    ListNode fast=dummy,slow=dummy;

    int i;
    for (i=0;fast.next!=null;i++)//Get the total length 
    	fast=fast.next;
    
    for (int j=i-k%i;j>0;j--) //Get the i-n%i th node
    	slow=slow.next;
    
    fast.next=dummy.next; //Do the rotation
    dummy.next=slow.next;
    slow.next=null;
    
    return dummy.next;       
    }
}
