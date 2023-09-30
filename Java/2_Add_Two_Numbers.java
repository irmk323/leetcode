
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
// consize solution
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // everytime we consume node, 
        // we need to care carryout and still nodes are there.
        int carry = 0;
        ListNode p,  dummy = new ListNode(0);
        // p moves for take next, but dummy is pointing the beginning.
        p = dummy;
        while(l1 != null || l2 !=null|| carry !=0){
            if(l1!= null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!= null){
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            p = p.next;
            carry /=10;
        }
        return dummy.next;
        
    }
} 

// // Time O(n) SpaceO(n)
// class Solution {
// public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//     ListNode dummyHead = new ListNode(0);
//     ListNode p = l1, q = l2, curr = dummyHead;
//     int carry = 0;
//     while (p != null || q != null) {
//         int x = (p != null) ? p.val : 0;
//         int y = (q != null) ? q.val : 0;
//         int sum = carry + x + y;
//         carry = sum / 10;
//         curr.next = new ListNode(sum % 10);
//         curr = curr.next;
//         if (p != null) p = p.next;
//         if (q != null) q = q.next;
//     }
//     if (carry > 0) {
//         curr.next = new ListNode(carry);
//     }
//     return dummyHead.next;
// }
// }
