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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.val, b.val));
            ListNode merged = new ListNode(0);
            ListNode dummy = merged;

            for(ListNode listnode : lists){
                if(listnode!= null){
                    pq.add(listnode);
                }
            }

            while(!pq.isEmpty()){
                
                ListNode min = pq.poll();
                dummy.next = min;
                if(min.next!= null){
                    pq.add(min.next);
                }
                dummy = dummy.next;
            }
        
        return merged.next;
        
    }
}

// As this is sorted, just keep one candidate from each non-empty list.
// pick up the cur nodes from lists
// put it in to the heap queue
// pull the smallest 
// put into the answer linked list 
// add another elem to heap